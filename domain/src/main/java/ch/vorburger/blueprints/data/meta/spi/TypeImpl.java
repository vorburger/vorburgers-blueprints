package ch.vorburger.blueprints.data.meta.spi;

import java.util.LinkedList;
import java.util.List;

import ch.vorburger.blueprints.data.meta.Property;
import ch.vorburger.blueprints.data.meta.Type;
import java.util.Collections;

/**
 * Implementation of Type.
 * 
 * Intended only for use by TypesProvider implementation - not API end-users!
 *
 * @author Michael Vorburger
 */
public class TypeImpl implements Type {

	private final String uri;
	private final Class<?> klass;
	private final List<Property> properties = new LinkedList<Property>();
	private final List<Property> roProperties = Collections.unmodifiableList(properties);
	
	public TypeImpl(String uri, Class<?> klass) {
		super();
		this.klass = klass;
		this.uri = uri;
	}

	public TypeImpl(String uri) {
		this(uri, null);
	}

	@Override
	public String getURI() {
		return uri;
	}

	@Override
	public List<Property> getProperties() {
		return roProperties;
	}

	@Override
	public Class<?> getInstanceClass() {
		return klass;
	}

	public void addProperty(Property p) {
		properties.add(p);
	}
	
}
