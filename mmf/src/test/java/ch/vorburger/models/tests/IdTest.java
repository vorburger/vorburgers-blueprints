package ch.vorburger.models.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

import ch.vorburger.models.core.id.Id;
import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.id.MapOfThingsWithIdsUtil;
import ch.vorburger.models.core.id.ThingWithId;
import ch.vorburger.models.tests.examples.SomeSecondOtherThingWithId;
import ch.vorburger.models.tests.examples.SomethingId;
import ch.vorburger.models.tests.examples.SomeFirstThingWithId;
import ch.vorburger.models.tests.examples.SomeFirstThingWithIdTempImpl;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class IdTest {

	@Test
	public void testSomethingWithId() {
		SomeFirstThingWithId somethingWithId = new SomeFirstThingWithIdTempImpl();
		somethingWithId.id1(123).id2("AN-ID").name("Mondpacxo");
		
		SomethingId somethingId = somethingWithId._id();
		assertThat(somethingId.id1(), equalTo(123L));
		assertThat(somethingId.id2(), equalTo("AN-ID"));
	}
	
	@Test
	public void testMapOfThingsWithIds() {
		MapOfThingsWithIds<SomethingId, SomeFirstThingWithId> map = MapOfThingsWithIdsUtil.newMap();
		
		SomeFirstThingWithId somethingWithId = new SomeFirstThingWithIdTempImpl();
		somethingWithId.id1(123).id2("AN-ID").name("Mondpacxo");
		map.put(somethingWithId);
		
		SomethingId somethingId = somethingWithId._id();
		somethingId.id2("AN-ID").id1(123);
		somethingWithId = map.get(somethingId);
		assertThat(somethingWithId.name(), equalTo("Mondpacxo"));
	}

	// TODO Implement this, later - when dyn. impl. is available
	@Test(expected=IllegalArgumentException.class)
	public void testMapOfThingsWithDifferentKindsOfIds() {
		fail("implement me!");
		MapOfThingsWithIds<Id, ThingWithId<Id>> map = MapOfThingsWithIdsUtil.newMap();
		
//		ThingWithId<Id> somethingWithId = new SomeFirstThingWithIdTempImpl();
//		map.put(somethingWithId);
//		
//		SomeSecondOtherThingWithId someSecondOtherThingWithId;
		// This should fail because it's not the right type:
//		map.put(someSecondOtherThingWithId);

	}
	
}
