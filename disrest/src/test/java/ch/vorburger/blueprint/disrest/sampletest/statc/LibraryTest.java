package ch.vorburger.blueprint.disrest.sampletest.statc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ch.vorburger.blueprint.disrest.core.RootResourceFactory;
import ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel.Library;


/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class LibraryTest {

	@Test
	public void testLibraryStaticallyTyped() {
		RootResourceFactory<Library> rootResourceFactory = new RootResourceFactoryTestImpl<Library>();
		Library library = rootResourceFactory.home();
		
		// The users are not available e.g. if we are not logged in (and probably also if we are logged in but not admin)
		assertThat(library.users().isAvailable(), is(false));

		library.availableBooks();
		
		// TODO Login authentication security!
		// library.login();
		// library.loggedInUser() ?
		assertThat(library.users().isAvailable(), is(true));

	}
}
