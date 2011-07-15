package ch.vorburger.blueprint.interactionframework.odata4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.odata4j.core.ODataConstants;
import org.odata4j.edm.EdmAssociation;
import org.odata4j.edm.EdmAssociationSet;
import org.odata4j.edm.EdmComplexType;
import org.odata4j.edm.EdmDataServices;
import org.odata4j.edm.EdmEntityContainer;
import org.odata4j.edm.EdmEntitySet;
import org.odata4j.edm.EdmEntityType;
import org.odata4j.edm.EdmNavigationProperty;
import org.odata4j.edm.EdmProperty;
import org.odata4j.edm.EdmSchema;
import org.odata4j.edm.EdmType;
import org.odata4j.producer.inmemory.InMemoryProducer;
import org.odata4j.producer.jpa.JPAEdmGenerator;

import ch.vorburger.blueprint.interactionframework.model.meta.EntityMetadata;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

/**
 * EdmDataServices builder.
 * 
 * To understand the implementation of this helper class, see InMemoryProducer & JPAEdmGenerator.
 * 
 * @see InMemoryProducer#buildMetadata()
 * @see JPAEdmGenerator#buildEdm(javax.persistence.EntityManagerFactory, String)
 * 
 * @author Michael Vorburger
 */
class EdmBuilder {

	// TODO Hmmm, what's this name for? Hard-code for now, but get back to it...
	private static final String CONTAINER_NAME = EdmBuilder.class.getName() + "_GeneratedDefaultContainer";

	private final String ns;
	private final EntityMetadata meta;
	
	public EdmBuilder(EntityMetadata meta, String namespace) {
		super();
		this.ns = namespace;
		this.meta = meta;
	}

	public EdmDataServices buildEdm() {
		// Create empty schemas/containers/entities/etc. lists:
		List<EdmEntitySet> entitySets = new ArrayList<EdmEntitySet>();
		List<EdmEntityType> entityTypes = new ArrayList<EdmEntityType>();
		List<EdmComplexType> complexTypes = new ArrayList<EdmComplexType>();
		List<EdmAssociation> associations = new ArrayList<EdmAssociation>();
		List<EdmAssociationSet> associationSets = new ArrayList<EdmAssociationSet>();

		// Now add all the Resource Types as Entity Types:
		for (EntityType resourceType : meta.getEntityTypes()) {
			String resourceName = resourceType.getName();

			List<String> keyNames = new LinkedList<String>();
			for (PropertyType idPropertyType : resourceType.getIdentityProperties()) {
				keyNames.add(idPropertyType.getName());
			}

			List<EdmProperty> edmProperties = new LinkedList<EdmProperty>();
			Collection<PropertyType> properties = resourceType.getProperties();
			for (PropertyType propertyType : properties) {
				EdmProperty edmProperty = toEdmProperty(propertyType);
				edmProperties.add(edmProperty);
			}

			// TODO Associations!

			// TODO Reverse Associations?

			List<EdmNavigationProperty> edmNavProperties = null;

			Boolean hasStream = false; // TODO Support streaming; e.g. attributes holding an Image!

			EdmEntityType eet = new EdmEntityType(ns, null, resourceName, hasStream, keyNames, edmProperties, edmNavProperties);
			entityTypes.add(eet);
			EdmEntitySet ees = new EdmEntitySet(resourceName, eet);
			entitySets.add(ees);
		}

		// Now stitch it all together appropriately:
		return createEdmDataServices(entitySets, associationSets, entityTypes, complexTypes, associations);
	}

	private EdmProperty toEdmProperty(PropertyType propertyType) {
		String name = propertyType.getName();
		EdmType type = toEdmType(propertyType);
		
		boolean nullable = false;    // TODO later, if required; from a isRequired() in PropertyType?
		Integer maxLength = null;    // TODO later, if required; from a getMaxLength() in PropertyType?
		Boolean fixedLength = false; // Nah, non-sense.
		Boolean unicode = true;      // Always, in Java
		
		// TODO What are these?! I can't even find any doc about this on odata.org...
		String storeGeneratedPattern = null;
		String fcTargetPath = null;
		String fcContentKind = null;
		String fcKeepInContent = null;
		String fcEpmContentKind = null;
		String fcEpmKeepInContent = null;
		
		return new EdmProperty(name, type, nullable, maxLength, unicode, fixedLength, storeGeneratedPattern,
				fcTargetPath, fcContentKind, fcKeepInContent, fcEpmContentKind, fcEpmKeepInContent);
	}

	// @see http://code.google.com/p/odata4j/issues/detail?id=46
	// package local because also used by AbstractInteractionFrameworkODataProducerImpl
	static EdmType toEdmType(PropertyType propertyType) {
		Class<?> javaType = propertyType.getValueType().getJavaClass();
		EdmType type = EdmType.forJavaType(javaType);
		if (type == null) {
			throw new IllegalArgumentException("Could not find the EDM-Type for Java type: " + javaType);
		}
		return type;
	}

	private EdmDataServices createEdmDataServices(List<EdmEntitySet> entitySets,
			List<EdmAssociationSet> associationSets, List<EdmEntityType> entityTypes,
			List<EdmComplexType> complexTypes, List<EdmAssociation> associations) 
	{
		List<EdmSchema> schemas = new ArrayList<EdmSchema>();
		List<EdmEntityContainer> containers = new ArrayList<EdmEntityContainer>();

		EdmEntityContainer container = new EdmEntityContainer(CONTAINER_NAME, true, null, entitySets, associationSets,
				null /* EDM Function Import List<EdmFunctionImport> */);
		containers.add(container);

		EdmSchema modelSchema = new EdmSchema(ns, null, entityTypes, complexTypes, associations, null);
		schemas.add(modelSchema);

		EdmSchema containerSchema = new EdmSchema(ns + "Container", null, null, null, null, containers);
		schemas.add(containerSchema);

		EdmDataServices services = new EdmDataServices(ODataConstants.DATA_SERVICE_VERSION, schemas);
		return services;
	}
}
