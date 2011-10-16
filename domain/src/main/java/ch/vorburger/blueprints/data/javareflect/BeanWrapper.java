package ch.vorburger.blueprints.data.javareflect;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.DataObjectImplUtil;

/**
 * Wraps a SDO DataObject to make it implement our (simplified) DataObject interface.
 * 
 * @author Michael Vorburger
 */
/* package-local */
class BeanWrapper implements DataObject {
	private static final long serialVersionUID = -5693810356649672157L;

	// If ever DataObject must support XPath-like SDO's "department.0/name",
	// company.get("department[1]/name"), "department[number=123]", then use
	// http://commons.apache.org/jxpath/ or http://jaxen.codehaus.org instead of BeanUtils.

	private final Object beanDataObject;

	public BeanWrapper(Object beanDataObject) {
		this.beanDataObject = beanDataObject;
	}

	@Override
	public Object get(String path) {
		DataObjectImplUtil.checkPath(path);
		try {
			return PropertyUtils.getProperty(beanDataObject, path);
		} catch (Exception e) {
			throw new IllegalArgumentException(path + " is not valid", e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(String path, Class<T> type) {
		DataObjectImplUtil.checkPath(path);
		Object o = get(path);
		return (T) ConvertUtils.convert(o, type);
	}

	@Override
	public void set(String path, Object value) {
		DataObjectImplUtil.checkPath(path);
		try {
			PropertyUtils.setProperty(beanDataObject, path, value);
		} catch (Exception e) {
			throw new IllegalArgumentException(path + " is not valid", e);
		}
	}

}
