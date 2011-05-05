package ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel;

import ch.vorburger.blueprint.disrest.core.MultiReferenceList;
import ch.vorburger.blueprint.disrest.core.OperationReturn;
import ch.vorburger.blueprint.disrest.core.Resource;

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
	MultiReferenceList<Book> availableBooks();

	MultiReferenceList<Author> allAuthors();

	/**
	 * Administrative User Management. 
	 */
	MultiReferenceList<User> users();

	// TODO is login just another operation, or some kind of special system property?!
	// Property<User> loggedInUser();
	// TODO if its an operation, does it have no arg (as in, that's handled out-of-band), or does it
	// tak. uid/pwd, and a second method signature variant with OAuth/OpenID token/info?
	OperationReturn<User> login();
}
