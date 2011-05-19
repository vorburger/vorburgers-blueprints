package ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel;

import static ch.vorburger.blueprint.disrest.core.ReferenceRemotingType.ONLY_REFERENCE;
import ch.vorburger.blueprint.disrest.core.MultiReferenceList;
import ch.vorburger.blueprint.disrest.core.OperationReturn;
import ch.vorburger.blueprint.disrest.core.Resource;
import ch.vorburger.blueprint.disrest.core.Resources;
import ch.vorburger.blueprint.disrest.core.statc.ReferenceRemoting;

/**
 * Library Resource (Sample/Test).
 * 
 * @author Michael Vorburger
 */
public interface Library extends Resource {

	// NOTE: No @Id - this is a Singleton

	/**
	 * All available books. There may be 'hidden' books in the Library which do not show up here,
	 * e.g. books lent in the past (which could show up from authors.books) but are no longer
	 * available to borrow.  If a book is in principle available to borrow but not right now
	 * because somebody else has it, it will still show up in this list though.
	 */
	@ReferenceRemoting(ONLY_REFERENCE)
	// TODO use @ReferenceRemoting(ReferenceRemotingType.EMBED_SOME) instead as an example & test
	MultiReferenceList<Book> availableBooks();

	@ReferenceRemoting(ONLY_REFERENCE)
	MultiReferenceList<Author> allAuthors();

	// TODO @ReferenceRemoting(ReferenceRemotingType.EMBED_SOME) should be implicit here!
	Resources<Book> searchBooks(String somethingToSearchFirstInBookTitleAndThenContent);

	
	/**
	 * Administrative User Management. 
	 */
	@ReferenceRemoting(ONLY_REFERENCE)
	MultiReferenceList<User> users();

	// TODO is login just another operation, or some kind of special system property?!
	// Property<User> loggedInUser();
	// tak. uid/pwd, and a second method signature variant with OAuth/OpenID token/info?
	// TODO if its an operation, does it have no arg (as in, that's handled out-of-band), or does it
	OperationReturn<User> login();
	
	
}
