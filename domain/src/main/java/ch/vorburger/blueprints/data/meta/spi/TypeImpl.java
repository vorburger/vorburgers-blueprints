package ch.vorburger.blueprints.data.meta.spi;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprints.data.meta.Property;
import ch.vorburger.blueprints.data.meta.Type;

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
	private final Map<String, Property> properties = new HashMap<String, Property>();
	private final Collection<Property> roProperties = Collections.unmodifiableCollection(properties.values());
	
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
	public Collection<Property> getProperties() {
		return roProperties;
	}

	@Override
	public Class<?> getInstanceClass() {
		return klass;
	}

	public void addProperty(Property p) {
		properties.put(p.getName(), p);
	}
	

	@Override
	public Property getProperty(String name) {
		Property p = properties.get(name);
		if (p == null)
			throw new IllegalArgumentException("No such property: " + name);
		return p;
	}

	// TODO @Override public String toString() {
}
