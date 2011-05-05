package ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel;

import static ch.vorburger.blueprint.disrest.core.ReferenceRemotingType.EMBED;
import ch.vorburger.blueprint.disrest.core.MultiReferenceList;
import ch.vorburger.blueprint.disrest.core.Property;
import ch.vorburger.blueprint.disrest.core.Resource;
import ch.vorburger.blueprint.disrest.core.statc.ReferenceRemoting;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface AuthorFull extends Resource {

	/**
	 * Full Author Biography. May be quite long.
	 */
	Property<String> fullBio();

	/**
	 * All the Books that this Author wrote.
	 */
	// EMBED because it seems reasonable to assume that given Author typically didn't write all that
	// many books, and that if full author details are requested directly knowing about all books
	// makes sense in a UI.
	@ReferenceRemoting(EMBED)
	MultiReferenceList<Book> books();

}
