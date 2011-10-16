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
		if (path.contains("/")) {
			throw new IllegalArgumentException("Use '.' instead of '/' to separate properties in DataObject path");
		}
		if (path.contains("[")) {
			throw new IllegalArgumentException("Using '[0-9]' index-based access is not allowed in these DataObjects");
		}
		if (path.contains("@")) {
			throw new IllegalArgumentException("Using '@' (XML Attribute vs. Element?) access is not allowed in these DataObjects (just try without)");
		}
		if (path.contains("=")) {
			throw new IllegalArgumentException("Using '=' (XPath-like matching) access is not allowed in these DataObjects");
		}
	}

}
