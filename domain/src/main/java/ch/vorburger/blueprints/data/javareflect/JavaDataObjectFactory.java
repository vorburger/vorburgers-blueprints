package ch.vorburger.blueprints.data.javareflect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.DataObjectFactory;
import ch.vorburger.blueprints.data.meta.Type;
import ch.vorburger.blueprints.data.meta.TypesProvider;
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
	// TODO private final List<Type> roRegisteredTypes = Collections.unmodifiableList(...);

	/**
	 * Register Class.
	 * 
	 * @param klass must have a default constructor
	 * @throws ObjectFactoryException if Class has no default constructor
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void register(Class<?> klass) throws ObjectFactoryException {
		ObjectFactory<?> factory = new ConstructorObjectFactory(klass);
		JavaTypeImpl type = new JavaTypeImpl(klass, factory );
		map.put(type.getURI(), type);
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
	public List<Type> getTypes() {
		// return map.values();
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("IMPLEMENT ME!");
	}

}
