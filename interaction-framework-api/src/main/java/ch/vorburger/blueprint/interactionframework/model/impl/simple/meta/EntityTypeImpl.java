package ch.vorburger.blueprint.interactionframework.model.impl.simple.meta;

import java.util.HashSet;
import java.util.Set;

import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

public class EntityTypeImpl extends DataStructTypeImpl implements EntityType {

	// TODO Change this... isKey should simply be a flag on Property.
	
	private final Set<PropertyType> identityProperties = new HashSet<PropertyType>();
	
	public EntityTypeImpl(String name) {
		super(name);
	}

	@Override
	public Set<PropertyType> getIdentityProperties() {
		return identityProperties;
	}

}
