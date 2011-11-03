package ch.vorburger.blueprints.data.meta;


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
	Iterable<? extends Type> getTypes();
	
}
