package ch.vorburger.blueprint.interactionframework.resources;

import java.util.Collection;

import ch.vorburger.blueprint.interactionframework.model.Entity;

/**
 * Collection of Entity/Resources.
 * 
 * Number of entries on this paged "Page" (Chunk) is size of 'entries' collection. Total number of
 * entries in this collection (if it wasn't paged) is in 'count'.
 * 
 * Note how this IS-A (extends) Resource, as it's addressable (has a URI) like any other Resource.
 * 
 * In a REST XML/JSON Representation, this may be represented by e.g. an Atom Feed.
 * 
 * @author Michael Vorburger & Kai Kreuzer
 */
public interface CollectionResource<E extends Entity> extends Resource {
	// TODO Something isn't quite right here yet.. for remoting we want Paging - but for the client
	// API we want (optionally) transparent buffered next-page-fetch on Iterator.next() - now to
	// provide for both access models?!

	// Properties
	// TODO Collection? Set? rather List, really..
	Collection<E> getEntries();

	/**
	 * Count number of Resources in this Resource Collection.
	 * 
	 * @return size, or Long.MAX_VALUE if unknown; 0 if empty (no Elements)
	 */
	// TODO better use Long.MAX_VALUE or -1 for unknown? Or Long and allow null?
	long getCount();

	// Links
	// TODO Next/Previous!

	// Operations
	Resource addResource(Resource newResource);

}
