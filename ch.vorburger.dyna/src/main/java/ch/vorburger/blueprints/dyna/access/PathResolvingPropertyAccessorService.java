package ch.vorburger.blueprints.dyna.access;



/**
 * PropertyAccessorService which resolves "paths".
 * 
 * As long as the remaining access path has e.g. dots,
 * it uses itself; when only a "simple" Property name
 * is left, it delegates.
 *
 * @author Michael Vorburger
 */
public class PathResolvingPropertyAccessorService extends PropertyAccessorServiceDelegate {

	public PathResolvingPropertyAccessorService(PropertyAccessorService delegate) {
		super(delegate);
	}

	@Override
	public Object getPropertyValue(Object bean, String propertyNamePath) throws IllegalArgumentException {
		String[] fields = splitPath(propertyNamePath);
		if (fields == null) {
			return delegate.getPropertyValue(bean, propertyNamePath);
		} else {
			Object last = resolve(fields, bean);
			return this.getPropertyValue(last, fields[fields.length - 1]);
		}
	}

	@Override
	public void setPropertyValue(Object bean, String propertyNamePath, Object value) throws IllegalArgumentException {
		String[] fields = splitPath(propertyNamePath);
		if (fields == null) {
			delegate.setPropertyValue(bean, propertyNamePath, value);
		} else {
			Object last = resolve(fields, bean);
			this.setPropertyValue(last, fields[fields.length - 1], value);
		}
	}

	private Object resolve(String[] propertyNames, Object o) {
		for (int i = 0; i < propertyNames.length - 1; i++) {
			o = this.getPropertyValue(o, propertyNames[i]);
			if (o == null) 
				throw new NullPointerException("Navigating property " + propertyNames[i] + " led to null");
		}
		return o;
	}


	
	// NOTE: WHILE EVERYTHING IS IN A MESS, I DUPLICATED THIS BELOW FROM domain/ to ch.vorburger.dyna
	
	/**
	 * Split path into properties.
	 * @param path Path
	 * @return String[], or null if no '.' in path
	 */
	// package-local, so that Unit Test can access it
	static String[] splitPath(String path) {
		checkPath(path);

		int idx = path.indexOf('.');
		if (idx == -1)
			return null;
		
		int i = 0;
		int lastIndex = 0;
		String[] properties = new String[2];
		
		do {
			properties = add(properties, i++, path.substring(lastIndex, idx));
			lastIndex = idx + 1;
			idx = path.indexOf('.', lastIndex);
		}
		while (idx != -1);
		properties = add(properties, i, path.substring(lastIndex));
		
		return properties;
	}

	private static void checkPath(String path) {
		if (path.indexOf('/') > -1) {
			throw new IllegalArgumentException("Use '.' instead of '/' to separate properties in DataObject path");
		}
		if (path.indexOf('[') > -1) {
			throw new IllegalArgumentException("Using '[0-9]' index-based access is not allowed in these DataObjects");
		}
		if (path.indexOf('@') > -1) {
			throw new IllegalArgumentException("Using '@' (XML Attribute vs. Element?) access is not allowed in these DataObjects (just try without)");
		}
		if (path.indexOf('=') > -1) {
			throw new IllegalArgumentException("Using '=' (XPath-like matching) access is not allowed in these DataObjects");
		}
	}

	private static String[] add(String[] array, int i, String element) {
		if (array.length < i+1) {
			String[] newProperties = new String[array.length + 1];
			System.arraycopy(array, 0, newProperties, 0, array.length);
			array = newProperties;
		}
		array[i] = element;
		return array;
	}

}
