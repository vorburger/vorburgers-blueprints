package ch.vorburger.blueprints.data.javareflect;

import java.lang.reflect.Field;
import java.util.Set;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.DataObjectImplUtil;

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
	private final boolean directFieldsInsteadOfJavaBean;
	
	BeanWrapper(JavaTypeImpl type) {
		this.beanDataObject = type.getObject();
		this.directFieldsInsteadOfJavaBean = type.directFieldsInsteadOfJavaBean;
	}

	private BeanWrapper(Object beanDataObject) {
		this.beanDataObject = beanDataObject;
		this.directFieldsInsteadOfJavaBean = false;
	}

	@Override
	public Object get(String path) {
		DataObjectImplUtil.checkPath(path);
		try {
			if (!directFieldsInsteadOfJavaBean)
				return PropertyUtils.getProperty(beanDataObject, path);
			else
				return getPrivateField(path);
		} catch (Exception e) {
			throwInvalidPath(path, e);
			return null; // never actually return null, but Java is too dumb!
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(String path, Class<T> type) {
		DataObjectImplUtil.checkPath(path);
		Object o = get(path);
		T value = (T) ConvertUtils.convert(o, type);
		if (DataObject.class.equals(type) && !(value instanceof DataObject)) {
			// If the contained object requires directFieldsInsteadOfJavaBean, it won't work, as we are cheating here:
			return (T) new BeanWrapper(value);
		}
		return value;
	}

	@Override
	public void set(String path, Object value) {
		DataObjectImplUtil.checkPath(path);
		try {
			if (!directFieldsInsteadOfJavaBean)
				PropertyUtils.setProperty(beanDataObject, path, value);
			else
				setPrivateField(path, value);
		} catch (Exception e) {
			throwInvalidPath(path, e);
		}
	}

	private Object getPrivateField(String path) throws Exception {
		Field field = getField(path);
		return field.get(beanDataObject);
	}

	private void setPrivateField(String path, Object value) throws Exception {
		Field field = getField(path);
		field.set(beanDataObject, value);
	}

	private Field getField(String path) throws NoSuchFieldException {
		// TODO getDeclaredField must be used instead of getField (which doesn't find private), but won't look in parent; should retry-loop here?
		Field field = beanDataObject.getClass().getDeclaredField(path);
		field.setAccessible(true);
		return field;
	}

	@SuppressWarnings("unchecked")
	private void throwInvalidPath(String path, Exception e) throws IllegalArgumentException {
		String allProperties;
		try {
			Set<String> allPropertiesList = PropertyUtils.describe(beanDataObject).keySet();
			allPropertiesList.remove("class");
			allProperties = allPropertiesList.toString();
		} catch (Exception ee) {
			allProperties = "??? " + ee.getMessage();
		}
		throw new IllegalArgumentException(path + " is not valid; allowed properties are: " + allProperties , e);
	}


}
