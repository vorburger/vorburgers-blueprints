package ch.vorburger.models.tests.examples;

import java.util.Date;

import ch.vorburger.models.core.id.ThingWithId;

/**
 * Something with the ID.
 *
 * @author Michael Vorburger
 */
public interface SomeSecondOtherThingWithId extends ThingWithId<SomethingId> {
	
	Date date();
	SomeSecondOtherThingWithId date(Date name);
	
	SomeSecondOtherThingWithId id1(long id1);
	
	SomeSecondOtherThingWithId id2(String id2);

}
