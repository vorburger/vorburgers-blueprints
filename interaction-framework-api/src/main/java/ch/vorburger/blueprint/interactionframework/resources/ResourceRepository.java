package ch.vorburger.blueprint.interactionframework.resources;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.resources.uri.URI;

/**
 * TODO Doc
 *
 * @author Michael Vorburger & Kai Kreuzer
 */
public interface ResourceRepository {

	Resource getHomepage(); // TODO ???
	
	Metadata getMetadata(); // TODO ???
	
	// TODO ResourceType getMetadata(URI uri);
	
	/**
	 * AKA HTTP GET, JPA find(), RDBMS SQL SELECT, etc.
	 * @param uri
	 * @return
	 */
	Resource getResource(URI uri);
	
	// TODO Cache-ability... boolean hasChanged(what-type-here?? ETag? TimeStamp? );
	
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
	DataStruct newEntity(DataStructType type);
	// TODO no? Resource newResource(EntityType type);
	
	// Add is on the CollectionResource
}
