package ch.vorburger.blueprints.dyna.access;

/**
 * Delegating PropertyAccessorService. 
 *
 * @author Michael Vorburger
 */
public abstract class PropertyAccessorServiceDelegate implements PropertyAccessorService {

	protected final PropertyAccessorService delegate;

	protected PropertyAccessorServiceDelegate(PropertyAccessorService delegate) {
		super();
		this.delegate = delegate;
	}

	public Object getPropertyValue(Object bean, String propertyNamePath) throws IllegalArgumentException {
		return delegate.getPropertyValue(bean, propertyNamePath);
	}

	public void setPropertyValue(Object bean, String propertyNamePath, Object value) throws IllegalArgumentException {
		delegate.setPropertyValue(bean, propertyNamePath, value);
	}

}
