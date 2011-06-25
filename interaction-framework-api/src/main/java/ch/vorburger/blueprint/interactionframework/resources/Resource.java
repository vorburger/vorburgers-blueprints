package ch.vorburger.blueprint.interactionframework.resources;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.Entity;
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
public interface Resource extends Entity {
	// TODO should we really extends Entity, or have an Entity getEntity() field?  Or even <T> get...Content/Body() - so it could be a statically typed one?
	
	// TODO Split this into a model.EntityWithIdentifier<T>, and make Resource extend EntityWithIdentifier<URI>
	
	URI getURI();
	
	// TODO Cache-ability... get ETag? TimeStamp?

	// TODO ResourceType getResourceType();
	
	// TODO ??? URI getLink(String linkNameRoleType);
	
	// No "parent", it's just a kind of 'default' role/type.
	// TODO URI getParentURI();
	// TODO No? Resource getParentResource();
	
	// TODO Operations...
}
