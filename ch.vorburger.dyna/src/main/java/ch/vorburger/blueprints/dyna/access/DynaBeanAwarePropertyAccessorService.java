package ch.vorburger.blueprints.dyna.access;

import ch.vorburger.blueprints.dyna.DynaBean;


/**
 * PropertyAccessorService which is DynaBean-aware.
 * 
 * Methods first checks if the passed bean is a DynaBean.
 * If it is, it's cast and the respective DynaBean method is invoked.
 * If it is not, then the method is forwarded to the delegate,
 * which is typically a Reflection-based implementation.  
 *
 * @author Michael Vorburger
 */
public class DynaBeanAwarePropertyAccessorService extends PropertyAccessorServiceDelegate {

	public DynaBeanAwarePropertyAccessorService(PropertyAccessorService delegate) {
		super(delegate);
	}

	@Override
	public Object getPropertyValue(Object bean, String propertyNamePath) throws IllegalArgumentException {
		if (bean instanceof DynaBean) {
			DynaBean dynaBean = (DynaBean) bean;
			return dynaBean.get(propertyNamePath);
		} else {
			return delegate.getPropertyValue(bean, propertyNamePath);
		}
	}

	@Override
	public void setPropertyValue(Object bean, String propertyNamePath, Object value) throws IllegalArgumentException {
		if (bean instanceof DynaBean) {
			DynaBean dynaBean = (DynaBean) bean;
			dynaBean.set(propertyNamePath, value);
		} else {
			delegate.setPropertyValue(bean, propertyNamePath, value);
		}
	}

}
