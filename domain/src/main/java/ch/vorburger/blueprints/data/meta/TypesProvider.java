package ch.vorburger.blueprints.data.meta;

import java.util.Map;


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
	Map<String, ? extends Type> getTypes();
	
}
