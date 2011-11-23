package ch.vorburger.blueprints.dyna.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import ch.vorburger.blueprints.dyna.access.PropertyAccessorService;

/**
 * PropertyAccessorService which uses's Apache Commons BeanUtils to access Java Bean properties.
 *
 * @author Michael Vorburger
 */
public class BeanUtilsPropertyAccessorService implements PropertyAccessorService {

	@Override
	public Object getPropertyValue(Object bean, String propertyNamePath) throws IllegalArgumentException {
		try {
			return PropertyUtils.getProperty(bean, propertyNamePath);
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException("Could not get property " + propertyNamePath + " of " + bean.getClass());
		} catch (InvocationTargetException e) {
			throw new IllegalArgumentException("Could not get property " + propertyNamePath + " of " + bean.getClass());
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException("Could not get property " + propertyNamePath + " of " + bean.getClass());
		}
	}

	@Override
	public void setPropertyValue(Object bean, String propertyNamePath, Object value) throws IllegalArgumentException {
		try {
			PropertyUtils.setProperty(bean, propertyNamePath, value);
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException("Could not set property " + propertyNamePath + " of " + bean.getClass());
		} catch (InvocationTargetException e) {
			throw new IllegalArgumentException("Could not set property " + propertyNamePath + " of " + bean.getClass());
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException("Could not set property " + propertyNamePath + " of " + bean.getClass());
		}
	}

}
