package ch.vorburger.blueprint.interactionframework.resources;

import ch.vorburger.blueprint.interactionframework.model.Entity;

// TODO Doc
public interface Resource extends Entity {
	// TODO should we really extends Entity, or have an Entity getEntity() field?
	
	URI getURI();
	
	// TODO Operations...
}
