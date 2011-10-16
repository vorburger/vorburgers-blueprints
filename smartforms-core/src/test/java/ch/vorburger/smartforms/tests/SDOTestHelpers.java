package ch.vorburger.smartforms.tests;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XSDHelper;

/**
 * Utilities for SDO.
 */
public final class SDOTestHelpers {
	private SDOTestHelpers() {
	}

	/**
	 * Load SDO Types from XML Schema (XSD).
	 * 
	 * @param scope SDO HelperContext
	 * @param resourceName as passed to {@link Class#getResource(String)} (start with '/')
	 * @throws IOException resourceName could not be be loaded 
	 */
	public static void loadTypesFromXMLSchemaFile(HelperContext scope, String resourceName) throws IOException {
		XSDHelper xsdHelper = scope.getXSDHelper();
		InputStream is = null;
		URL url = SDOTestHelpers.class.getResource(resourceName);
		if (url == null) {
			throw new IOException(resourceName + " not found on classpath");
		}
		is = url.openStream();
		xsdHelper.define(is, url.toString());
	}

}
