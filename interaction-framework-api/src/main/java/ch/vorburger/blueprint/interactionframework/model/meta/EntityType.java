package ch.vorburger.blueprint.interactionframework.model.meta;

import java.util.Set;

/**
 * Type descriptor of an EntityWithIdentity.
 * 
 * @author Michael Vorburger
 */
public interface EntityType extends DataStructType {

	/**
	 * Properties forming the Identity.
	 * 
	 * This is a sub-set of the {@link #getPropertyTypes()}, not a separate set.
	 * 
	 * @return
	 */
	Set<PropertyType> getIdentityProperties();

}
