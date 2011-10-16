package ch.vorburger.blueprints.data.meta;

import java.util.List;

/**
 * Lists Types.
 *
 * @author Michael Vorburger
 */
public interface TypesProvider {

	/**
	 * Returns Types.
	 * 
	 * @return immutable read-only List of Types
	 */
	List<Type> getTypes();
	
}
