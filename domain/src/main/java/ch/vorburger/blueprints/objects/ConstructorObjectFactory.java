package ch.vorburger.blueprints.objects;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ObjectFactory which creates objects by calling the default constructor of a Class.
 * 
 * @author Michael Vorburger
 */
public class ConstructorObjectFactory<T> implements ObjectFactory<T> {

	// TODO This was created for something which I ended up not doing; if this util is not going to be used elsewhere, completely delete it again later.
	
	private static final String MSG = "Class does not seem to have a working defaul constructor: ";
	private final Constructor<T> constructor;

	public ConstructorObjectFactory(Class<T> klass) throws ObjectFactoryException {
		super();
		try {
			constructor = klass.getConstructor();
			// Now let's just test it once...
			constructor.newInstance();
		} catch (SecurityException e) {
			throw new ObjectFactoryException(MSG + klass, e);
		} catch (NoSuchMethodException e) {
			throw new ObjectFactoryException(MSG + klass, e);
		} catch (IllegalArgumentException e) {
			throw new ObjectFactoryException(MSG + klass, e);
		} catch (InstantiationException e) {
			throw new ObjectFactoryException(MSG + klass, e);
		} catch (IllegalAccessException e) {
			throw new ObjectFactoryException(MSG + klass, e);
		} catch (InvocationTargetException e) {
			throw new ObjectFactoryException(MSG + klass, e);
		}
	}
	
	@Override
	public T getObject() {
		try {
			return constructor.newInstance();
		} catch (Exception e) {
			throw new Error("newInstance() worked earlier, but not anymore?!", e);
		}
	}

}
