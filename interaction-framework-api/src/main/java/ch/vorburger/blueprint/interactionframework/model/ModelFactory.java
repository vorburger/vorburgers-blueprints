package ch.vorburger.blueprint.interactionframework.model;

import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;

public interface ModelFactory {

	DataStruct newDataStruct(DataStructType type);


	
	Entity newEntity(EntityType type);

	EntityId newEntityId(EntityType type);
	
	
// This should not be needed?
//	Property<?> newProperty(PropertyType type);
	
}
