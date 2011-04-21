package ch.vorburger.models.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.id.MapOfThingsWithIdsUtil;
import ch.vorburger.models.tests.examples.SomethingId;
import ch.vorburger.models.tests.examples.SomethingWithId;
import ch.vorburger.models.tests.examples.SomethingWithIdTempImpl;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class IdTest {

	@Test
	public void testSomethingWithId() {
		SomethingWithId somethingWithId = new SomethingWithIdTempImpl();
		somethingWithId.id1(123).id2("AN-ID").name("Mondpacxo");
		
		SomethingId somethingId = somethingWithId._id();
		assertThat(somethingId.id1(), equalTo(123L));
		assertThat(somethingId.id2(), equalTo("AN-ID"));
	}
	
	@Test
	public void testMapOfThingsWithIds() {
		MapOfThingsWithIds<SomethingId, SomethingWithId> map = MapOfThingsWithIdsUtil.newMap();
		
		SomethingWithId somethingWithId = new SomethingWithIdTempImpl();
		somethingWithId.id1(123).id2("AN-ID").name("Mondpacxo");
		map.put(somethingWithId);
		
		SomethingId somethingId = somethingWithId._id();
		somethingId.id2("AN-ID").id1(123);
		somethingWithId = map.get(somethingId);
		assertThat(somethingWithId.name(), equalTo("Mondpacxo"));
	}

}
