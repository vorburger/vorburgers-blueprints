package ch.vorburger.blueprint.interactionframework.model.impl.simple.meta;

import java.util.Collection;
import java.util.HashSet;

import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

public class EntityTypeImpl implements EntityType {

	private final String name;
	private final Collection<PropertyType> properties;

	public EntityTypeImpl(String name) {
		super();
		this.name = name;
		this.properties = new HashSet<PropertyType>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Collection<PropertyType> getProperties() {
		return properties;
	}

	@Override
	public Property<?> getProperty(String name) {
        throw new UnsupportedOperationException();
	}

	@Override
	public Property<?> getProperty(PropertyType propertyType) {
        throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getEntityType() {
        throw new UnsupportedOperationException();
	}

}
