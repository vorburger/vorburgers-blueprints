package ch.vorburger.blueprints.data;

/**
 * Static utility helpers typically needed by implementations of DataObject.
 *
 * @author Michael Vorburger
 */
public final class DataObjectImplUtil {
	private DataObjectImplUtil() {
	}
	
	public static void checkPath(String path) {
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

	/**
	 * Split path into properties.
	 * @param path Path
	 * @return String[], or null if no '.' in path
	 */
	public static String[] splitPath(String path) {
		DataObjectImplUtil.checkPath(path);

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
