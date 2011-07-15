package ch.vorburger.blueprint.interactionframework.model.meta;


/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface EntityMetadata {

	Iterable<EntityType> getEntityTypes();

	EntityType getEntityType(String oEntitySetName);
	
}
