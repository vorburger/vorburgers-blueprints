package ch.vorburger.blueprint.interactionframework.model.impl.simple.meta;

import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprint.interactionframework.model.meta.EntityMetadata;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;

public class EntityMetadataImpl implements EntityMetadata {

	private final Map<String, EntityType> entries = new HashMap<String, EntityType>();

	// This is NOT @Override - it's part of this implementation, not the Interface
	// TODO Use MML's MapOfThingsWithIds ?
	public Map<String, EntityType> getEntityTypesMap() {
		return entries;
	}
	
	@Override
	public Iterable<EntityType> getEntityTypes() {
		return entries.values();
	}

	@Override
	public EntityType getEntityType(String entityName) {
		return entries.get(entityName);
	}

}
