package ch.vorburger.blueprints.data.meta.spi;

import java.util.List;

import ch.vorburger.blueprints.data.meta.Property;
import ch.vorburger.blueprints.data.meta.Type;

/**
 * Simple (Leaf) Type.
 * 
 * @see SimpleTypeRegistry
 *
 * @author Michael Vorburger
 */
public class SimpleTypeImpl implements Type {

	private final Class<?> klass;

	/* package-local, must always use SimpleTypeRegistry */
	SimpleTypeImpl(Class<?> klass) {
		super();
		this.klass = klass;
	}

	@Override
	public String getURI() {
		return "simple:" + klass.getName();
	}

	@Override
	public Class<?> getInstanceClass() {
		return klass;
	}

	@Override
	public List<Property> getProperties() {
		return null;
	}

	@Override
	public Property getProperty(String name) {
		return null;
	}

	@Override
	public String toString() {
		return "Simple/Leaf Type for " + klass.getName(); 
	}
}
