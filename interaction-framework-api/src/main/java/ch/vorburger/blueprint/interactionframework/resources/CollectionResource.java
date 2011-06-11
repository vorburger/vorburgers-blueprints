package ch.vorburger.blueprint.interactionframework.resources;

import java.util.Collection;

import ch.vorburger.blueprint.interactionframework.model.Entity;

/**
 * //TODO Doc
 * 
 * Number of entries on this paged "Page" (Chunk) is size of 'entries' collection.
 * Total number of entries in this collection (if it wasn't paged) is in 'count'.  
 *
 * @author Michael Vorburger & Kai Kreuzer
 */
public interface CollectionResource extends Resource {

	// Properties
	Collection<Entity> getEntries();
	long getCount();
	
	// Links
	
	
	// Operations
	Resource addResource(Resource newResource);
	
}
