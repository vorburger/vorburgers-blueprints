package ch.vorburger.blueprint.interactionframework.model.impl.simple;

import ch.vorburger.blueprint.interactionframework.model.Entity;
import ch.vorburger.blueprint.interactionframework.model.EntityId;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;

public class EntityImplINTERNAL extends DataStructImplINTERNAL implements Entity {

	public EntityImplINTERNAL(EntityTypeImplINTERNAL type) {
		super(type);
	}

	@Override
	public EntityId getIdentity() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public EntityType getDataStructType() {
		return (EntityType) super.getDataStructType();
	}
	
	
}
