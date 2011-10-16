package ch.vorburger.blueprints.data.xmlxsd;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.tuscany.sdo.api.SDOUtil;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.DataObjectFactory;

import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XSDHelper;

/**
 * DataObjectFactory based on XML Schema.
 *
 * @author Michael Vorburger
 */
public class XSDDataObjectFactory implements DataObjectFactory /* TODO , TypesProvider */ {

	private final HelperContext sdoContext;
	private final XSDHelper xsdHelper;

	public XSDDataObjectFactory() {
		this(SDOUtil.createHelperContext());
	}

	public XSDDataObjectFactory(HelperContext sdoContext) {
		super();
		this.sdoContext = sdoContext;
		this.xsdHelper = sdoContext.getXSDHelper();
	}

	/**
	 * Load SDO Types from XML Schema (XSD).
	 * 
	 * @param resourceName as passed to {@link Class#getResource(String)} (start with '/')
	 * @throws IOException resourceName could not be be loaded 
	 */
	public void register(String resourceName) throws IOException {
		InputStream is = null;
		URL url = XSDDataObjectFactory.class.getResource(resourceName);
		if (url == null) {
			throw new IOException(resourceName + " not found on classpath");
		}
		is = url.openStream();
		xsdHelper.define(is, url.toString());
		is.close();
	}

	@Override
	public DataObject create(String typeURI) {
		final int pos = typeURI.lastIndexOf('#');
		String nsURI = typeURI.substring(0, pos);
		String typeName = typeURI.substring(pos + 1);
		
		try {
			commonj.sdo.DataObject sdoDO = sdoContext.getDataFactory().create(nsURI, typeName);
			return new DataObjectWrapper(sdoDO);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Unknown TypeURI for this DataObjectFactory: " + typeURI);
		}
	}

//	@Override
//	public <T> T create(Class<T> klass) {
//		throw new UnsupportedOperationException();
//	}

}
