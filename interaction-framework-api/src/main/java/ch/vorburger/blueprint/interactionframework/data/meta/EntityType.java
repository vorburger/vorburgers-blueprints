package ch.vorburger.blueprint.interactionframework.data.meta;

import java.util.Collection;

//TODO Doc
public interface EntityType /* TODO extends Entity */ {

	String getName();

	Collection<PropertyType> getProperties();

}
