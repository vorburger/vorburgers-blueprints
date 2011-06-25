package ch.vorburger.blueprint.interactionframework.model.repo;

import java.util.List;

import ch.vorburger.blueprint.interactionframework.model.Entity;
import ch.vorburger.blueprint.interactionframework.model.EntityId;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityMetadata;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;



/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface EntityRepository {

	EntityMetadata getMetadata();
	
	/**
	 * TODO Doc better... "is already detached" (like a JPA find & detach combined)
	 */
	Entity getEntity(EntityId id) throws EntityNotFoundException, RepositoryException;
	
	/**
	 * Save
	 * @param resource
	 */
	Entity updateEntity(Entity resource);
	
	void deleteEntity(EntityId... ids);
	
	List<Entity> find(EntityType type, EntityRepositoryQuery query);
	//EntityRepositoryQuery newQuery();
}
