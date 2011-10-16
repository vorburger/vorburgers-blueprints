package ch.vorburger.blueprints.data.javareflect;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprints.data.DataObjectFactory;
import ch.vorburger.blueprints.objects.ObjectFactory;

import commonj.sdo.DataObject;

/**
 * DataObjectFactory based on Java Types.
 * 
 * @author Michael Vorburger
 */
public class JavaDataObjectFactory implements DataObjectFactory /* TODO , TypesProvider */ {

	private final Map<Class<?>, ObjectFactory<?>> map = new HashMap<Class<?>, ObjectFactory<?>>();
	
	/**
	 * Register Class.
	 * All interfaces of the classes are registered.
	 * 
	 * @param klass must have a default constructor
	 */
	public void register(Class<?> klass) {
		throw new UnsupportedOperationException("IMPLEMENT ME!");
	}

	/**
	 * @param nsURI Java Package name
	 * @param typeName Java Class or Interface name
	 */
	@Override
	public DataObject create(String nsURI, String typeName) {
		throw new UnsupportedOperationException("IMPLEMENT ME!");
	}

}
