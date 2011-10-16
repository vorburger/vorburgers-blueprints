package ch.vorburger.blueprints.data;

/**
 * Factory for DataObjects.
 * 
 * @author Michael Vorburger
 */
public interface DataObjectFactory {

	/**
	 * Create a new dynamic DataObject.
	 * 
	 * @param uri URI of the Type to be created
	 * @return DataObject, or null if this DataObjectFactory does not handle that Type
	 */
	DataObject create(String typeURI);

	// TODO Could offer, if needed: DataObject create(Type nsURI);
	
// Would this really be needed, is there a use case for such a usage?!
//	/**
//	 * Create a new statically typed DataObject. This really only makes sense for the
//	 * JavaDataObjectFactory.
//	 * 
//	 * @param klass static Java type (interface or class) of the DataObject
//	 * @return DataObject, or null if this DataObjectFactory does not handle that Type
//	 * 
//	 * @throws UnsupportedOperationException if static beans are not supported by this factory
//	 */
//	<T> T create(Class<T> klass);

}
