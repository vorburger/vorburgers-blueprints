package ch.vorburger.blueprint.disrest.core;

import java.io.Serializable;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface Resource/* <T_ID> */extends Serializable {

	// TODO Property<T_ID or just String> id(); ?

	// TODO version() ??

	/**
	 * Saves the Resource. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance.
	 */
	// TODO Resource save()
	
	// TODO DeleteResponse delete()
}
