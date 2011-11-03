package ch.vorburger.blueprints.data.xmlxsd;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tuscany.sdo.api.SDOUtil;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.DataObjectFactory;
import ch.vorburger.blueprints.data.meta.Type;
import ch.vorburger.blueprints.data.meta.TypesProvider;
import ch.vorburger.blueprints.data.meta.spi.PropertyImpl;
import ch.vorburger.blueprints.data.meta.spi.TypeImpl;

import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XSDHelper;

/**
 * DataObjectFactory based on XML Schema.
 *
 * @author Michael Vorburger
 */
public class XSDDataObjectFactory implements DataObjectFactory, TypesProvider {

	private static final char DELIMITER = '#';
	
	//private final HelperContext sdoContext;
	private final XSDHelper xsdHelper;
	private final DataFactory dataFactory;
	private final List<Type> registeredTypes = new LinkedList<Type>();
	private final Map<String, TypeImpl> registeredTypesMap = new HashMap<String, TypeImpl>();
	private final Map<String, TypeImpl> roRegisteredTypes = Collections.unmodifiableMap(registeredTypesMap);

	public XSDDataObjectFactory() {
		this(SDOUtil.createHelperContext());
	}

	public XSDDataObjectFactory(HelperContext sdoContext) {
		super();
		//this.sdoContext = sdoContext;
		this.xsdHelper = sdoContext.getXSDHelper();
		this.dataFactory = sdoContext.getDataFactory();
	}

	/**
	 * Load SDO Types from XML Schema (XSD).
	 * 
	 * @param resourceName as passed to {@link Class#getResource(String)} (start with '/')
	 * @throws IOException resourceName could not be be loaded 
	 */
	@SuppressWarnings("unchecked")
	public void register(String resourceName) throws IOException {
		// 1. Read schema
		InputStream is = null;
		URL url = XSDDataObjectFactory.class.getResource(resourceName);
		if (url == null) {
			throw new IOException(resourceName + " not found on classpath");
		}
		is = url.openStream();
		List<commonj.sdo.Type> sdoTypes = xsdHelper.define(is, url.toString());
		is.close();
		
		// 2. First pass, create Types
		Map<commonj.sdo.Type, TypeImpl> newTypes = new HashMap<commonj.sdo.Type, TypeImpl>();
		for (commonj.sdo.Type sdoType : sdoTypes) {
			TypeImpl type = new TypeImpl(sdoType.getURI() + "#" + sdoType.getName());
			newTypes.put(sdoType, type);
		}
		
		// 3. Second pass, create & correctly wire Properties and their Types
		for (Entry<commonj.sdo.Type, TypeImpl> entry : newTypes.entrySet()) {
			final commonj.sdo.Type sdoType = entry.getKey();
			final TypeImpl ourNewType = entry.getValue();
			List<commonj.sdo.Property> sdoProperties = sdoType.getProperties();
			for (commonj.sdo.Property sdoProperty : sdoProperties) {
				Type propertyType = newTypes.get(sdoType);
				if (propertyType == null) {
					throw new IllegalArgumentException(sdoType.getURI() + " " + sdoType.getName() + " could not be found while registering " + resourceName);
				}
				PropertyImpl property = new PropertyImpl(sdoProperty.getName(), propertyType);
				ourNewType.addProperty(property);
			}
		} 

		// 4. All went well, now add them to the instance
		registeredTypes.addAll(newTypes.values());
		for (TypeImpl type : newTypes.values()) {
			registeredTypesMap.put(type.getURI(), type);
		}
	}

	@Override
	public DataObject create(String typeURI) {
		if (typeURI == null)
			throw new IllegalArgumentException("typeURI == null");
		
		// TODO Implement this differently... keep Map<String typeURI, commonj.sdo.Type sdoType> -> faster!
		final int pos = typeURI.lastIndexOf(DELIMITER);
		String nsURI = typeURI.substring(0, pos);
		String typeName = typeURI.substring(pos + 1);
		
		try {
			commonj.sdo.DataObject sdoDO = dataFactory.create(nsURI, typeName);
			return new DataObjectWrapper(sdoDO);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Unknown TypeURI for this DataObjectFactory: " + typeURI);
		}
	}

	@Override
	public Map<String, ? extends Type> getTypes() {
		return roRegisteredTypes;
	}

//	@Override
//	public <T> T create(Class<T> klass) {
//		throw new UnsupportedOperationException();
//	}

}
