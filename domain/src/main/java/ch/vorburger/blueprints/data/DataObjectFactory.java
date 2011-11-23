package ch.vorburger.blueprints.data;

import ch.vorburger.blueprints.data.meta.Type;
import ch.vorburger.blueprints.objects.ObjectFactoryException;

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
	 * @throws ObjectFactoryException 
	 */
	DataObject create(String typeURI) throws ObjectFactoryException;

	DataObject create(Type type) throws ObjectFactoryException;
	
	
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
