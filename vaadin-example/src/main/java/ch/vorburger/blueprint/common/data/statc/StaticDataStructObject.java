package ch.vorburger.blueprint.common.data.statc;

import ch.vorburger.blueprint.common.data.DataStructObject;

/**
 * Something which is an instance of a DataStruct with a statically typed interface API.
 * 
 * @author Michael Vorburger
 */
public interface StaticDataStructObject<StructT> extends DataStructObject {

	// <StructT, PropertyT> PropertyT getPropertyValue(StaticDataProp<StructT, PropertyT> property);
	<PropertyT> PropertyT getPropertyValue(StaticDataProp<StructT, PropertyT> property);
	
	// TODO not Object, but strongly typed!
	// TODO DataStructObject setPropertyValue(DataProp property, Object propertyValue);


	// TODO multi-variant for the DataProp instead String signature


}
