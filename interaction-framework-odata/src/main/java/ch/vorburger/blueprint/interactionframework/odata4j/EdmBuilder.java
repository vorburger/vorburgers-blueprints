package ch.vorburger.blueprint.interactionframework.odata4j;

import java.util.ArrayList;
import java.util.List;

import org.core4j.Enumerable;
import org.odata4j.core.ODataConstants;
import org.odata4j.edm.EdmAssociation;
import org.odata4j.edm.EdmAssociationSet;
import org.odata4j.edm.EdmComplexType;
import org.odata4j.edm.EdmDataServices;
import org.odata4j.edm.EdmEntityContainer;
import org.odata4j.edm.EdmEntitySet;
import org.odata4j.edm.EdmEntityType;
import org.odata4j.edm.EdmSchema;
import org.odata4j.producer.inmemory.InMemoryProducer;
import org.odata4j.producer.jpa.JPAEdmGenerator;

import ch.vorburger.blueprint.interactionframework.resources.ResourceRepository;

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

	private static final String CONTAINER_NAME = EdmBuilder.class.getName() + "_GeneratedDefaultContainer"; // TODO
																												// Huh?
	private final String namespace;
	private final ResourceRepository repo;

	public EdmBuilder(ResourceRepository repo, String namespace) {
		super();
		this.namespace = namespace;
		this.repo = repo;
	}

	public EdmDataServices buildEdm() {
		List<EdmSchema> schemas = new ArrayList<EdmSchema>();
		List<EdmEntityContainer> containers = new ArrayList<EdmEntityContainer>();
		List<EdmEntitySet> entitySets = new ArrayList<EdmEntitySet>();
		List<EdmEntityType> entityTypes = new ArrayList<EdmEntityType>();
		List<EdmComplexType> complexTypes = new ArrayList<EdmComplexType>();
		List<EdmAssociation> associations = new ArrayList<EdmAssociation>();
		List<EdmAssociationSet> associationSets = new ArrayList<EdmAssociationSet>();

		EdmEntityContainer container = new EdmEntityContainer(CONTAINER_NAME, true, null, entitySets, associationSets,
				null /* EDM Function Import List<EdmFunctionImport> */);
        containers.add(container);

		EdmSchema modelSchema = new EdmSchema(namespace, null, entityTypes, complexTypes, associations, null);
        schemas.add(modelSchema);

        EdmSchema containerSchema = new EdmSchema(namespace + "Container", null, null, null, null, containers);
        schemas.add(containerSchema);
        
        EdmDataServices services = new EdmDataServices(ODataConstants.DATA_SERVICE_VERSION, schemas);
        return services;
	}
}
