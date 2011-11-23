package ch.vorburger.blueprints.data.javareflect;

import java.lang.reflect.Field;

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
	
	/**
	 * May be null, if this POJO Class cannot be instantiated (e.g. if it doesn't have a default constructor)
	 */
	private final ObjectFactory<?> beanFactory;
	
	final boolean directFieldsInsteadOfJavaBean;
	
	/**
	 * Constructor.
	 * 
	 * @param klass
	 * @param beanFactory may be null, if this POJO Class cannot be instantiated (e.g. if it doesn't have a default constructor)
	 * @param javaDataObjectFactory
	 * @param directFieldsInsteadOfJavaBean
	 * @throws ObjectFactoryException
	 */
	JavaTypeImpl(Class<?> klass, ObjectFactory<?> beanFactory, JavaDataObjectFactory javaDataObjectFactory, boolean directFieldsInsteadOfJavaBean) throws ObjectFactoryException {
		super(NS + checkClass(klass));
		this.beanFactory = beanFactory;
		this.directFieldsInsteadOfJavaBean = directFieldsInsteadOfJavaBean;
		
		// Could use http://static.springsource.org/spring/docs/3.0.4.RELEASE/javadoc-api/org/springframework/util/ReflectionUtils.html ?
		
		if (!directFieldsInsteadOfJavaBean) {
			// Not entirely sure this is the best way, but it works for now:
			WrapDynaClass wrapDynaClass = WrapDynaClass.createDynaClass(klass);
			for (DynaProperty beanutilsProperty : wrapDynaClass.getDynaProperties()) {
				// TODO Nested properties are probably not yet handled correctly here..
				String name = beanutilsProperty.getName();
				Class<?> classType = beanutilsProperty.getType();
				addProperty(klass, javaDataObjectFactory, name, classType);
			}
		} else {
			Class<?> currentClass = klass;
			do {
				Field[] fields = currentClass.getDeclaredFields();
				for (Field field : fields) {
					if (!field.isSynthetic()) {
						addProperty(klass, javaDataObjectFactory, field.getName(), field.getType());
					}
				}
				currentClass = currentClass.getSuperclass();
			} while (currentClass != null);
		}
	}

	private void addProperty(Class<?> klass, JavaDataObjectFactory javaDataObjectFactory, String name, Class<?> classType) throws ObjectFactoryException {
		if (classType != Class.class) {
			if (classType != klass) {
				Type type = javaDataObjectFactory.register(classType);
				Property property = new PropertyImpl(name, type);
				super.addProperty(property);
			} else {
				// This is not trivial to handle... would have to consider inter-dependant circles between two classes also, not just self-references..
				throw new IllegalArgumentException(klass.getName() + "." + name + " is self-circular; TODO handle this!");
			}
				
		}
	}

	Object getObject() throws ObjectFactoryException {
		if (beanFactory == null) {
			throw new ObjectFactoryException("Cannot getObject(), because no POJO Java Class ObjectFactory (doesn't have a default constructor?) for: " + this.getURI());
		}
		return beanFactory.getObject();
	}

	private static String checkClass(Class<?> klass) {
		String name = klass.getCanonicalName();
		if (name == null) 
			throw new IllegalArgumentException(klass.toString() + " cannot be used here");
		return name;
	}

}
