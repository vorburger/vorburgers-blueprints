package ch.vorburger.blueprint.interactionframework.model.meta;


/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface EntityMetadata {

	// TODO Use Map here instead, like elsewhere now?
	
	Iterable<EntityType> getEntityTypes();

	EntityType getEntityType(String name);
	
}
