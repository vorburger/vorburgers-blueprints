package ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel;

import ch.vorburger.blueprint.disrest.core.MultiReferenceList;
import ch.vorburger.blueprint.disrest.core.Property;
import ch.vorburger.blueprint.disrest.core.Resource;
import ch.vorburger.blueprint.disrest.core.statc.Id;

/**
 * Author Resource (Sample/Test).
 *
 * @author Michael Vorburger
 */
public interface Author extends Resource {

	@Id
	Property<Long> id();
	
	Property<String> name();

	/**
	 * All the Books that this Author wrote.
	 */
	MultiReferenceList<Book> books();

}
