package ch.vorburger.blueprint.interactionframework.resources;

import ch.vorburger.blueprint.interactionframework.model.Entity;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;

/**
 * TODO Doc
 *
 * @author Michael Vorburger & Kai Kreuzer
 */
public interface ResourceManager {

	Resource getHomepage(); // TODO ???
	/* TODO Metadata*/Resource getMetadata(); // TODO ???
	
	/**
	 * AKA HTTP GET, JPA find(), RDBMS SQL SELECT, etc.
	 * @param uri
	 * @return
	 */
	Resource getResource(URI uri);
	
	/**
	 * AKA HTTP PUT, JPA merge(), RDBMS SQL UPDATE, etc.
	 * @param resource
	 */
	void updateResource(Resource resource);
	
	/**
	 * AKA HTTP DELETE, JPA remove(), RDBMS SQL DELETE, etc.
	 * @param uri
	 */
	void deleteResource(URI uri);

	/**
	 * 
	 * @param type
	 * @return an Entity, which may be a Resource (sub-type) also
	 */
	Entity newEntity(EntityType type);
	// TODO no? Resource newResource(EntityType type);
	

	// Add is on the CollectionResource
}
