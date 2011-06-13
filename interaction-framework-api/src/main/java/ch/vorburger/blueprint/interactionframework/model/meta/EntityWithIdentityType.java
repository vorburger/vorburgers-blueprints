package ch.vorburger.blueprint.interactionframework.model.meta;

import java.util.Collection;

/**
 * Type descriptor of an EntityWithIdentity.
 * 
 * @author Michael Vorburger
 */
public interface EntityWithIdentityType extends EntityType {

	Collection<PropertyType> getIdentityProperties();

}
