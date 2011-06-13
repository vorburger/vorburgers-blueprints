package ch.vorburger.blueprint.interactionframework.model.meta;

import java.util.Set;

import ch.vorburger.blueprint.interactionframework.model.Entity;

/**
 * Type descriptor of an Entity.
 * 
 * @author Michael Vorburger
 */
public interface EntityType extends Entity {

	String getName();

	// TODO EntityType getParentEntityType()
	
	Set<PropertyType> getProperties();

}
