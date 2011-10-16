package ch.vorburger.blueprints.data.javareflect;

import ch.vorburger.blueprints.data.meta.spi.TypeImpl;
import ch.vorburger.blueprints.objects.ConstructorObjectFactory;
import ch.vorburger.blueprints.objects.ObjectFactory;

/* package-local */
class JavaTypeImpl extends TypeImpl {

	static final String NS = "java:";
	private final ObjectFactory<?> beanFactory;
	
	public JavaTypeImpl(Class<?> klass, ObjectFactory<?> beanFactory) {
		super(NS + checkClass(klass));
		this.beanFactory = beanFactory;
		
		// TODO super.addProperty(BeanUtils... Introspect!)
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
