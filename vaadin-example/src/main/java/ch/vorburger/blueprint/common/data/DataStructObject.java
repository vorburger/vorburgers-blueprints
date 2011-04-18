package ch.vorburger.blueprint.common.data;



/**
 * Something which is an instance of a DataStruct.
 * 
 * @see DataStruct
 * 
 * @author Michael Vorburger
 */
public interface DataStructObject {
	// better name??

	DataStruct struct();

	// TODO rename to just get() ?
	Object getPropertyValue(String propertyName);
	Object getPropertyValue(DataProp property);

	// TODO rename to just set() ?
	DataStructObject setPropertyValue(String propertyName, Object propertyValue);
	DataStructObject setPropertyValue(DataProp property, Object propertyValue);
	
	/**
	 * Add a value to a multi-valued property.
	 * 
	 * @param multiplePropertyName name of Property, must be multi-valued
	 * @param propertyValueToAdd may be an instance of DataStructObject or just an e.g. String
	 */
	// TODO rename to just get() ?
	void addPropertyValue(String multiplePropertyName, Object propertyValueToAdd);
}
