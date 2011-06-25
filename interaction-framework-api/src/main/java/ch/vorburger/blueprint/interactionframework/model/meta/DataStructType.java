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
	
	Set<PropertyType> getProperties();

}
