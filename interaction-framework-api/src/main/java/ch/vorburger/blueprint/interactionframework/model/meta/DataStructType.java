package ch.vorburger.blueprint.interactionframework.model.meta;

import java.util.Map;

/**
 * Type descriptor of an Entity.
 * 
 * A.K.A XML Schema (XSD) Complex Type, JDO/JPA Embedded Class, Java Bean.
 * 
 * @see EntityType for a sub-type which supports Identity (which this does not)
 * 
 * @author Michael Vorburger
 */
public interface DataStructType extends DataType /* TODO , DataStruct */{

	Map<String, PropertyType> getPropertyTypesMap();

	// TODO Really needed? Set<PropertyType> OR Iterable<PropertyType> getPropertyTypes();
	// TODO PropertyType getPropertyType(String name);
	// TODO Set<String> getPropertyTypeNames();

	// No EntityType getParentEntityType() - while an implementation of this meta type system may
	// have super types, from a client perspective we just flatten them and don't expose that here.

}
