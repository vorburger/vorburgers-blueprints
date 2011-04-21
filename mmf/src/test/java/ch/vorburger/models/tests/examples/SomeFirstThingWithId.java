package ch.vorburger.models.tests.examples;

import ch.vorburger.models.core.id.ThingWithId;

/**
 * Something with the ID.
 *
 * @author Michael Vorburger
 */
public interface SomeFirstThingWithId extends ThingWithId<SomethingId> {
	
	String name();
	SomeFirstThingWithId name(String name);
	
	SomeFirstThingWithId id1(long id1);
	
	SomeFirstThingWithId id2(String id2);

}
