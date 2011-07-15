package ch.vorburger.blueprint.interactionframework.model.meta;

import java.util.Set;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;

/**
 * Type descriptor of an Entity.
 * 
 * A.K.A XML Schema (XSD) Complex Type, JDO/JPA Embedded Class, Java Bean.
 * 
 * @author Michael Vorburger
 */
public interface DataStructType extends DataType, DataStruct {

	String getName();

	// TODO EntityType getParentEntityType()
	
	// TODO Iterable<PropertyType> instead Set
	Set<PropertyType> getProperties();
	// TODO Map<String, PropertyType> getPropertiesMap();
	// TODO PropertyType getProperty(String name);
	// TODO Set<String> getPropertyNames();

}
