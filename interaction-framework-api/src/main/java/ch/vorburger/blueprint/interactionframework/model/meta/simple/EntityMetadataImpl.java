package ch.vorburger.blueprint.interactionframework.model.meta.simple;

import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprint.interactionframework.model.meta.EntityMetadata;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;

/**
 * Implementation of EntityMetadata.
 * 
 * This is a typical simple bean style implementation. It will be useful for many use cases. It is
 * however by not means necessarily the only available/possible implementation; typical alternative
 * implementation is a wrapper around some other exists type meta system.
 * 
 * @author Michael Vorburger
 */
public class EntityMetadataImpl implements EntityMetadata {

	private final Map<String, EntityType> entries = new HashMap<String, EntityType>();

	public Map<String, EntityType> getEntityTypesMap() {
		return entries;
	}

	public EntityMetadataImpl addEntityType(EntityType entityType) {
		getEntityTypesMap().put(entityType.getName(), entityType);
		return this;
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
