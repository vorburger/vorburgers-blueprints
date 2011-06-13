package ch.vorburger.blueprint.interactionframework.resources;

import ch.vorburger.blueprint.interactionframework.model.Entity;
import ch.vorburger.blueprint.interactionframework.resources.uri.URI;

/**
 * Resource.
 * 
 * This has Identity and is "externally addressable" - as opposed to {@link Entity}.
 *
 * @see Entity
 * 
 * @author Michael Vorburger & Kai Kreuzer
 */
public interface Resource extends Entity {
	// TODO should we really extends Entity, or have an Entity getEntity() field?  Or even <T> get...Content/Body() - so it could be a statically typed one?
	
	// TODO Split this into a model.EntityWithIdentifier<T>, and make Resource extend EntityWithIdentifier<URI>
	
	URI getURI();
	
	// TODO Operations...
}
