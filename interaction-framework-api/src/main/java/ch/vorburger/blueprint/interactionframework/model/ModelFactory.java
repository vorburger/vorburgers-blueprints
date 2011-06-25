package ch.vorburger.blueprint.interactionframework.model;

import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

public interface ModelFactory {

	Entity newEntity(EntityType type);

	DataStruct newDataStruct(DataStructType type);

	EntityId newEntityId(EntityType type);
	
	Property<?> newProperty(PropertyType type);
	
}
