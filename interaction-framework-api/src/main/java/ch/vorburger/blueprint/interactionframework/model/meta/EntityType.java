package ch.vorburger.blueprint.interactionframework.model.meta;

import java.util.Collection;

import ch.vorburger.blueprint.interactionframework.model.Entity;

//TODO Doc
public interface EntityType extends Entity {

	String getName();

	// TODO EntityType getParentEntityType()
	
	Collection<PropertyType> getProperties();

}
