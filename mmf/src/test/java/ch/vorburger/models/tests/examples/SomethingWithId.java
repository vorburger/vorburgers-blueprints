package ch.vorburger.models.tests.examples;

import ch.vorburger.models.core.id.ThingWithId;

/**
 * Something with the ID.
 *
 * @author Michael Vorburger
 */
public interface SomethingWithId extends ThingWithId<SomethingId> {
	
	String name();
	SomethingWithId name(String name);
	
	SomethingWithId id1(long id1);
	
	SomethingWithId id2(String id2);

}
