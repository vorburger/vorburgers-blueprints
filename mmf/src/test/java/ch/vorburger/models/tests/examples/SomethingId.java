package ch.vorburger.models.tests.examples;

import ch.vorburger.models.core.id.Id;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface SomethingId extends Id {
	
	long id1();
	SomethingId id1(long id1);
	
	String id2();
	SomethingId id2(String id2);

}
