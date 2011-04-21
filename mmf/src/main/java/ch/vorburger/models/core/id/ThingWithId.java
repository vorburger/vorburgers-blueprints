package ch.vorburger.models.core.id;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface ThingWithId<T extends Id> extends Id {

	/**
	 * ID of this object.
	 * 
	 * Underscore prefix is used to distinguish this from normal other attributes (as those are not allowed to start with an '_').
	 * 
	 * @return the Id as an Id object
	 */
	T _id();
	
	// There is, intentionally, no setter (set_id or void _id(Id id)), because this is intended as a read-only operation!
}
