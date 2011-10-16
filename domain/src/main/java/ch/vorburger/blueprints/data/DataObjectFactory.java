package ch.vorburger.blueprints.data;

import commonj.sdo.DataObject;
import commonj.sdo.helper.DataFactory;

/**
 * Factory for SDO DataObjects.
 * 
 * Similar to {@link DataFactory}, but separate so that we can use Generics (which SDO does not),
 * avoid the static INSTANCE, and possible provide different implementations than those of the SDO
 * provider.
 * 
 * @author Michael Vorburger
 */
public interface DataObjectFactory {

	/**
	 * Create a new dynamic DataObject.
	 * 
	 * @param nsURI Namespace URI of the Type to be created
	 * @param typeName Name of the Type to be created
	 * @return DataObject, or null if this DataObjectFactory does not handle that Type
	 */
	DataObject create(String nsURI, String typeName);

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
