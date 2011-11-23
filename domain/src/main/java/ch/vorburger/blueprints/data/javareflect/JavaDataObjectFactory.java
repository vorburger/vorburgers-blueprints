package ch.vorburger.blueprints.data.javareflect;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.DataObjectFactory;
import ch.vorburger.blueprints.data.meta.Type;
import ch.vorburger.blueprints.data.meta.TypesProvider;
import ch.vorburger.blueprints.data.meta.spi.SimpleTypeRegistry;
import ch.vorburger.blueprints.objects.ConstructorObjectFactory;
import ch.vorburger.blueprints.objects.ObjectFactory;
import ch.vorburger.blueprints.objects.ObjectFactoryException;

/**
 * DataObjectFactory based on Java Types.
 * 
 * @author Michael Vorburger
 */
public class JavaDataObjectFactory implements DataObjectFactory, TypesProvider {

	// TODO BeanUtils' WrapDynaClass is using a ContextClassLoaderLocal WeakHashMap...
	// do we nee this as well here?!  If somebody keeps a JavaDataObjectFactory around in a static?!
	
	private final Map<String, JavaTypeImpl> nameMap = new HashMap<String, JavaTypeImpl>();
	private final Map<String, ? extends Type> roRegisteredTypes = Collections.unmodifiableMap(nameMap);
	private final Map<Class<?>, JavaTypeImpl> classMap = new HashMap<Class<?>, JavaTypeImpl>();

	/**
	 * Register Class.
	 * 
	 * @param klass must have a default constructor
	 * @return Type (new, or existing previously registered instance if not first time call) 
	 * @throws ObjectFactoryException if Class has no default constructor
	 */
	public Type register(Class<?> klass) throws ObjectFactoryException {
		return register(klass, false);
	}

	/**
	 * Register Class.
	 * 
	 * Instead of looking for & using JavaBean getters & setters, this does direct access to (all, incl. private) fields. 
	 * @return Type (new, or existing previously registered instance if not first time call) 
	 * @throws ObjectFactoryException 
	 */
	public Type registerUsingDirectFieldsInsteadOfJavaBean(Class<?> klass) throws ObjectFactoryException {
		return register(klass, true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Type register(Class<?> klass, boolean directFieldsInsteadOfJavaBean) throws ObjectFactoryException {
		Type simpleType = SimpleTypeRegistry.getSimpleType(klass);
		if (simpleType != null)
			return simpleType;
		
		Type knownComplexType = classMap.get(klass);
		if (knownComplexType != null)
			return knownComplexType;
		
		// We'll now try to create an ObjectFactory for the class.
		// If we can't, that's not so bad - we'll still have Type information, 
		// just not be able to create instances (only wrap existing POJOs)
		ObjectFactory<?> factory = null;
		try {
			factory = new ConstructorObjectFactory(klass);
		} catch (ObjectFactoryException e) {
			// IGNORE
		}
		
		JavaTypeImpl type = new JavaTypeImpl(klass, factory, this, directFieldsInsteadOfJavaBean);
		nameMap.put(type.getURI(), type);
		classMap.put(klass, type);
		return type; 
	}
	
	/**
	 * Factory method.
	 * 
	 * @param nsURI Java Package name
	 * @param typeName Java Class or Interface name
	 * @throws ObjectFactoryException 
	 */
	@Override
	public DataObject create(String typeURI) throws ObjectFactoryException {
		if (typeURI == null)
			throw new IllegalArgumentException("typeURI == null");
		
		if (!typeURI.startsWith(JavaTypeImpl.NS)) 
			throw new IllegalArgumentException("Must start with prefix '" + JavaTypeImpl.NS + "' : " + typeURI);

		JavaTypeImpl type = nameMap.get(typeURI);
		return new BeanWrapper(type);
	}

	@Override
	public DataObject create(Type type) throws ObjectFactoryException {
		if (type == null)
			throw new IllegalArgumentException("type == null");

		if (!(type instanceof JavaTypeImpl)) 
			throw new IllegalArgumentException(this.getClass().getName() + " cannot create " + type.toString());
		
		JavaTypeImpl javaTypeImpl = (JavaTypeImpl) type;
		return new BeanWrapper(javaTypeImpl);
	}
	
	@Override
	public Map<String, ? extends Type> getTypes() {
		return roRegisteredTypes;
	}

	public DataObject wrap(Object bean) {
		Type type;
		// TODO Remove this try/catch! Need to refactor above...
		try {
			type = register(bean.getClass());
		} catch (ObjectFactoryException e) {
			throw new IllegalArgumentException("Huh, this should never happen?!", e);
		}
		JavaTypeImpl javaTypeImpl = (JavaTypeImpl) type;
		return new BeanWrapper(javaTypeImpl, bean);
	}
}
