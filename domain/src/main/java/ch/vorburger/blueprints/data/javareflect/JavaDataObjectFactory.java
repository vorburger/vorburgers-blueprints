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

	private final Map<String, JavaTypeImpl> map = new HashMap<String, JavaTypeImpl>();
	private final Map<String, ? extends Type> roRegisteredTypes = Collections.unmodifiableMap(map);

	/**
	 * Register Class.
	 * 
	 * @param klass must have a default constructor
	 * @return 
	 * @throws ObjectFactoryException if Class has no default constructor
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Type register(Class<?> klass) throws ObjectFactoryException {
		Type simpleType = SimpleTypeRegistry.getSimpleType(klass);
		if (simpleType != null)
			return simpleType;
		
		ObjectFactory<?> factory = new ConstructorObjectFactory(klass);
		JavaTypeImpl type = new JavaTypeImpl(klass, factory, this);
		
		JavaTypeImpl existingType = map.get(type.getURI());
		if (existingType == null) {
			map.put(type.getURI(), type);
			return type; 
		} else {
			return existingType;
		}
	}

	/**
	 * Factory method.
	 * 
	 * @param nsURI Java Package name
	 * @param typeName Java Class or Interface name
	 */
	@Override
	public DataObject create(String typeURI) {
		if (typeURI == null)
			throw new IllegalArgumentException("typeURI == null");
		
		if (!typeURI.startsWith(JavaTypeImpl.NS)) 
			throw new IllegalArgumentException("Must start with prefix '" + JavaTypeImpl.NS + "' : " + typeURI);

		JavaTypeImpl type = map.get(typeURI);
		return new BeanWrapper(type.getObject());
	}

	@Override
	public DataObject create(Type type) {
		if (type == null)
			throw new IllegalArgumentException("type == null");

		if (!(type instanceof JavaTypeImpl)) 
			throw new IllegalArgumentException(this.getClass().getName() + " cannot create " + type.toString());
		
		JavaTypeImpl javaTypeImpl = (JavaTypeImpl) type;
		return new BeanWrapper(javaTypeImpl.getObject());
	}
	
	@Override
	public Map<String, ? extends Type> getTypes() {
		return roRegisteredTypes;
	}

}
