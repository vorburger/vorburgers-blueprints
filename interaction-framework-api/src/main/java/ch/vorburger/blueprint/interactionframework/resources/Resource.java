package ch.vorburger.blueprint.interactionframework.resources;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.resources.uri.URI;

/**
 * Resource.
 * 
 * This has Identity and is "externally addressable" - as opposed to {@link DataStruct}.
 *
 * @see DataStruct
 * 
 * @author Michael Vorburger & Kai Kreuzer
 */
public interface Resource extends DataStruct {
	// TODO should we really extends Entity, or have an Entity getEntity() field?  Or even <T> get...Content/Body() - so it could be a statically typed one?
	
	// TODO Split this into a model.EntityWithIdentifier<T>, and make Resource extend EntityWithIdentifier<URI>
	
	URI getURI();
	
	// TODO Operations...
}
