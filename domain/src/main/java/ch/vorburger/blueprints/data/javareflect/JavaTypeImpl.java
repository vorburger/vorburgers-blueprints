package ch.vorburger.blueprints.data.javareflect;

import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.WrapDynaClass;

import ch.vorburger.blueprints.data.meta.Property;
import ch.vorburger.blueprints.data.meta.Type;
import ch.vorburger.blueprints.data.meta.spi.PropertyImpl;
import ch.vorburger.blueprints.data.meta.spi.TypeImpl;
import ch.vorburger.blueprints.objects.ObjectFactory;
import ch.vorburger.blueprints.objects.ObjectFactoryException;

/* package-local */
class JavaTypeImpl extends TypeImpl {

	static final String NS = "java:";
	private final ObjectFactory<?> beanFactory;
	
	JavaTypeImpl(Class<?> klass, ObjectFactory<?> beanFactory, JavaDataObjectFactory javaDataObjectFactory) throws ObjectFactoryException {
		super(NS + checkClass(klass));
		this.beanFactory = beanFactory;
		
		// Not entirely sure this is the best way, but it works for now:
		WrapDynaClass wrapDynaClass = WrapDynaClass.createDynaClass(klass);
		for (DynaProperty beanutilsProperty : wrapDynaClass.getDynaProperties()) {
			// TODO Nested properties are probably not yet handled correctly here..
			String name = beanutilsProperty.getName();
			Class<?> classType = beanutilsProperty.getType();
			if (classType != Class.class) {
				Type type = javaDataObjectFactory.register(classType);
				Property property = new PropertyImpl(name, type);
				super.addProperty(property);
			}
		}
	}

	Object getObject() {
		return beanFactory.getObject();
	}
	
	private static String checkClass(Class<?> klass) {
		String name = klass.getCanonicalName();
		if (name == null) 
			throw new IllegalArgumentException(klass.toString() + " cannot be used here");
		return name;
	}

}
