package ch.vorburger.blueprints.objects;

import java.lang.reflect.Constructor;

/**
 * ObjectFactory which creates objects by calling the default constructor of a static Java Class.
 * 
 * @author Michael Vorburger
 */
public class ConstructorObjectFactory<T> implements ObjectFactory<T> {

	// TODO This was created for something which I ended up not doing; if this utility is not going to be used elsewhere, completely delete it again later.
	
	private static final String MSG = "Class does not seem to have a working defaul constructor: ";
	private final Constructor<T> constructor;

	public ConstructorObjectFactory(Class<T> klass) throws ObjectFactoryException {
		super();
		try {
			constructor = klass.getConstructor();
			// Now let's just test it once...
			constructor.newInstance();
		} catch (Exception e) {
			throw new ObjectFactoryException(MSG + klass.toString(), e);
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
