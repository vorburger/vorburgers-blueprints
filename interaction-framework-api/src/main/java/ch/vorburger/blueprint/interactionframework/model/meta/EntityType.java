package ch.vorburger.blueprint.interactionframework.model.meta;

import java.util.Set;

/**
 * Type descriptor of an EntityWithIdentity.
 * 
 * @author Michael Vorburger
 */
public interface EntityType extends DataStructType {

	Set<PropertyType> getIdentityProperties();

}
