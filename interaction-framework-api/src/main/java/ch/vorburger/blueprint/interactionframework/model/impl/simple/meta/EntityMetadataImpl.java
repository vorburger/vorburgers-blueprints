package ch.vorburger.blueprint.interactionframework.model.impl.simple.meta;

import java.util.HashSet;
import java.util.Set;

import ch.vorburger.blueprint.interactionframework.model.meta.EntityMetadata;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;

public class EntityMetadataImpl implements EntityMetadata {

	private final Set<EntityType> entries;
	
	public EntityMetadataImpl() {
		this.entries = new HashSet<EntityType>();
	}

	@Override
	public Set<EntityType> getEntityTypes() {
		return entries;
	}

}
