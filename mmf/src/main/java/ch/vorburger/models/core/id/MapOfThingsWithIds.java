package ch.vorburger.models.core.id;

import java.util.Map;

/**
 * Map of things with Id.
 *
 * @author Michael Vorburger
 */
public interface MapOfThingsWithIds<T_ID extends Id, T_TWID extends ThingWithId<T_ID>> extends Map<T_ID, T_TWID> {
	// TODO Give this a better name!!

	void put(T_TWID somethingWithId);
	
}
