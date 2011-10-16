package ch.vorburger.blueprints.data.meta.spi;

import ch.vorburger.blueprints.data.meta.Property;
import ch.vorburger.blueprints.data.meta.Type;

/**
 * Implementation of Property.
 *
 * Intended only for use by TypesProvider implementation - not API end-users!
 *
 * @author Michael Vorburger
 */
public class PropertyImpl implements Property {

	private final String name;
	private final Type type;
	
	public PropertyImpl(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Type getType() {
		return type;
	}

}
