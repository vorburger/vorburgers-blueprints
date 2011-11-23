package ch.vorburger.blueprints.dyna.access;

import org.springframework.beans.PropertyAccessor;

/**
 * PropertyAccessor Service.
 * 
 * Like Spring's {@link PropertyAccessor}, but not a "wrapper" around a bean,
 * but a "Service" which takes the Bean to access as first argument.
 * Like BeanUtil Apache Commons BeanUtils PropertyUtils. 
 *
 * @author Michael Vorburger
 */
public interface PropertyAccessorService {
	// TODO Naming? *Service suffix may not be best, but there already is a PropertyAccessorUtil in Spring...
	
	Object getPropertyValue(Object bean, String propertyNamePath) throws IllegalArgumentException;

	void setPropertyValue(Object bean, String propertyNamePath, Object value) throws IllegalArgumentException;
	
}
