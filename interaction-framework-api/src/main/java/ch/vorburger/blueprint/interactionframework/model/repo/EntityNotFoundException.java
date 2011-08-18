package ch.vorburger.blueprint.interactionframework.model.repo;

/**
 * Exception if Entity is not found.
 * 
 * This is thrown if
 * {@link EntityRepository#getEntity(ch.vorburger.blueprint.interactionframework.model.EntityId)}
 * cannot find an Entity because the ID does not exist in the repository.
 * 
 * @author Michael Vorburger
 */
public class EntityNotFoundException extends Exception {

}
