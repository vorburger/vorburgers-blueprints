package ch.vorburger.blueprint.interactionframework.model;

import ch.vorburger.blueprint.interactionframework.model.meta.EntityWithIdentityType;

/**
 * Entity with an Identity, composed of one or several of it's properties.
 * 
 * @author Michael Vorburger
 */
public interface EntityWithIdentity extends Entity {

	Identity getIdentity();
	
	@Override
	EntityWithIdentityType getEntityType();

}
