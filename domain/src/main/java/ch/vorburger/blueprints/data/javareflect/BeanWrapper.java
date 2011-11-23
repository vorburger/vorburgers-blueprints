package ch.vorburger.blueprints.data.javareflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.DataObjectImplUtil;
import ch.vorburger.blueprints.data.meta.Property;
import ch.vorburger.blueprints.objects.ObjectFactoryException;

/**
 * Wraps a Java Bean to make it implement our (simplified) DataObject interface.
 * 
 * @author Michael Vorburger
 */
/* package-local */
class BeanWrapper implements DataObject {
	private static final long serialVersionUID = -5693810356649672157L;

	// If ever DataObject must support XPath-like SDO's "department.0/name",
	// company.get("department[1]/name"), "department[number=123]", then use
	// http://commons.apache.org/jxpath/ or http://jaxen.codehaus.org instead of BeanUtils.

	// Could use http://static.springsource.org/spring/docs/3.0.4.RELEASE/javadoc-api/org/springframework/util/ReflectionUtils.html, spring-beans ?
	
	private final Object beanDataObject;
	private final JavaTypeImpl javaTypeImpl;
	
	BeanWrapper(JavaTypeImpl type) throws ObjectFactoryException {
		this.beanDataObject = type.getObject();
		this.javaTypeImpl = type;
	}

	BeanWrapper(JavaTypeImpl type, Object beanDataObject) {
		this.beanDataObject = beanDataObject;
		this.javaTypeImpl = type;
	}

	@Override
	public Object get(String path) {
		String[] fields = DataObjectImplUtil.splitPath(path);
		if (fields == null) {
			return getSimple(path);
		} else {
			DataObject o = this;
			for (int i = 0; i < fields.length - 1; i++) {
				o = o.get(fields[i], DataObject.class);
			}
			return o.get(fields[fields.length - 1]);
		}
	}

	private Object getSimple(String name) {
		try {
			Object o;
			if (!javaTypeImpl.directFieldsInsteadOfJavaBean)
				o = PropertyUtils.getProperty(beanDataObject, name);
			else
				o = getPrivateField(name);
			
			// Is this a reference? If yes, we have to wrap it...
			Property p = javaTypeImpl.getProperty(name);
			if (p != null && p.getType().getInstanceClass() == null) {
				JavaTypeImpl javaType = (JavaTypeImpl) p.getType();
				return new BeanWrapper(javaType , o);
			}
			return o;
			
		} catch (IllegalAccessException e) {
			throwInvalidPath(name, e);
		} catch (IllegalArgumentException e) {
			throwInvalidPath(name, e);
		} catch (NoSuchFieldException e) {
			throwInvalidPath(name, e);
		} catch (InvocationTargetException e) {
			throwInvalidPath(name, e);
		} catch (NoSuchMethodException e) {
			throwInvalidPath(name, e);
		}
		return null; // never actually returns null, but Java is too dumb!
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(String path, Class<T> type) {
		Object o = get(path);
		T value = (T) ConvertUtils.convert(o, type);
// TODO Remove; as already done above, don't need to redo it here?		
//		if (DataObject.class.equals(type) && !(value instanceof DataObject)) {
//			return (T) new BeanWrapper(javaTypeImpl, value);
//		}
		return value;
	}

	@Override
	public void set(String path, Object value) {
		String[] fields = DataObjectImplUtil.splitPath(path);
		if (fields == null) {
			setSimple(path, value);
		} else {
			DataObject o = this;
			for (int i = 0; i < fields.length - 1; i++) {
				o = o.get(fields[i], DataObject.class);
			}
			o.set(fields[fields.length - 1], value);
		}
	}

	private void setSimple(String path, Object value) {
		if (value instanceof BeanWrapper) {
			// Unwrap if neccessary
			BeanWrapper beanWrapper = (BeanWrapper) value;
			value = beanWrapper.beanDataObject;
		}
		try {
			if (!javaTypeImpl.directFieldsInsteadOfJavaBean)
				PropertyUtils.setProperty(beanDataObject, path, value);
			else
				setPrivateField(path, value);
		} catch (NoSuchFieldException e) {
			throwInvalidPath(path, e);
		} catch (IllegalAccessException e) {
			throwInvalidPath(path, e);
		} catch (InvocationTargetException e) {
			throwInvalidPath(path, e);
		} catch (NoSuchMethodException e) {
			throwInvalidPath(path, e);
		}
	}

	private Object getPrivateField(String path) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field field = getPrivateReflectionField(path);
		return field.get(beanDataObject);
	}

	private void setPrivateField(String path, Object value) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field field = getPrivateReflectionField(path);
		field.set(beanDataObject, value);
	}

	private Field getPrivateReflectionField(String path) throws NoSuchFieldException {
		Field field = beanDataObject.getClass().getDeclaredField(path);
		field.setAccessible(true);
		return field;
	}

	@SuppressWarnings("unchecked")
	private void throwInvalidPath(String path, Exception e) throws IllegalArgumentException {
		String allProperties = javaTypeImpl.getProperties().toString();
//		try {
//			Set<String> allPropertiesList = PropertyUtils.describe(beanDataObject).keySet();
//			allPropertiesList.remove("class");
//			allProperties = allPropertiesList.toString();
//		} catch (Throwable ee) {
//			allProperties = "??? " + ee.getMessage();
//		}
		throw new IllegalArgumentException(path + " is not valid; allowed properties are: " + allProperties , e);
	}


}
