package ch.vorburger.blueprint.interactionframework.data;

import ch.vorburger.blueprint.interactionframework.data.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.data.meta.PropertyType;

// TODO Doc
public interface Entity {

	Property<?> getProperty(String name);
	Property<?> getProperty(PropertyType propertyType);

	// TODO References/Links, how-to?  Or just properties?!
	
	EntityType getEntityType();
	
}
