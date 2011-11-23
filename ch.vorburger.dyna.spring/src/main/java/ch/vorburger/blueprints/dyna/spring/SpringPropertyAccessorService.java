package ch.vorburger.blueprints.dyna.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyAccessorFactory;

import ch.vorburger.blueprints.dyna.access.PropertyAccessorService;

/**
 * PropertyAccessorService which uses's Spring Bean/Core Reflection to access Java Bean properties.
 * 
 * @author Michael Vorburger
 */
public class SpringPropertyAccessorService implements PropertyAccessorService {

	@Override
	public Object getPropertyValue(Object bean, String propertyNamePath) throws IllegalArgumentException {
		try {
			return PropertyAccessorFactory.forBeanPropertyAccess(bean).getPropertyValue(propertyNamePath);
		} catch (BeansException e1) {
			// TODO Log?
			try {
				return PropertyAccessorFactory.forDirectFieldAccess(bean).getPropertyValue(propertyNamePath);
			} catch (BeansException e2) {
				throw new IllegalArgumentException("Could not get property " + propertyNamePath + " of " + bean.getClass(), e2);
			}
		}
	}

	@Override
	public void setPropertyValue(Object bean, String propertyNamePath, Object value) throws IllegalArgumentException {
		try {
			PropertyAccessorFactory.forBeanPropertyAccess(bean).setPropertyValue(propertyNamePath, value);
		} catch (BeansException e1) {
			try {
				PropertyAccessorFactory.forDirectFieldAccess(bean).setPropertyValue(propertyNamePath, value);
			} catch (BeansException e2) {
				throw new IllegalArgumentException("Could not set property " + propertyNamePath + " of " + bean.getClass(), e2);				
			}
		}
	}

}
