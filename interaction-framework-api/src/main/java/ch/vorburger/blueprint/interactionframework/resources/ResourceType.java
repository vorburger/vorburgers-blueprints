package ch.vorburger.blueprint.interactionframework.resources;

import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;

/**
 * 
 * 
 * @author Michael Vorburger
 */
public interface ResourceType extends EntityType {

	// TODO This is probably where we'll define what "Parameters" (URL Query Params?) a Resource
	// has?!

	/**
	 * Is there a (default) Collection holding (all or a sub-set of) all Resources of this Resource
	 * Type? Not all Resources are actually listable; for example the Homepage (Entry point) is not.
	 * 
	 * A.K.A JDO's Extent.
	 */
	// TODO boolean isQueryable();

	// Needed? E.g. the meta.Property's parent is the Entity, so a URI of it is always "composite"
	// TODO ResourceType getParentResourceType();
}
