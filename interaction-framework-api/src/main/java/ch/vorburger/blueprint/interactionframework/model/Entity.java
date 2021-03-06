package ch.vorburger.blueprint.interactionframework.model;

import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;

/**
 * Entity with an Identity, composed of one or several of it's properties.
 * 
 * @author Michael Vorburger
 */
public interface Entity extends DataStruct {

	EntityId getIdentity();
	
	@Override
	EntityType getDataStructType();

}
