package ch.vorburger.blueprint.disrest.sampletest.statc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import ch.vorburger.blueprint.disrest.core.MultiReferenceList;
import ch.vorburger.blueprint.disrest.core.OperationReturn;
import ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel.Author;
import ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel.Book;
import ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel.Library;
import ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel.User;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public class LibraryTest {

	@Test
	public void testLibraryStaticallyTyped() throws Exception {
		// RootResourceFactory<Library> rootResourceFactory = new
		// RootResourceFactoryTestImpl<Library>();
		// Library library = rootResourceFactory.home();
		TestLibraryImpl library = new TestLibraryImpl();

		// The users are not available e.g. if we are not logged in (and probably also if we are
		// logged in but not admin)
		assertThat(library.users().isAvailable(), is(false));
		assertThat(library.hasMadeBackEndAccess(), is(false));

		MultiReferenceList<Book> booksRef = library.availableBooks();
		assertThat(library.hasMadeBackEndAccess(), is(false));
		
		List<Book> books = booksRef.value().pageSize(10);
		Book firstBook = books.get(0);
		assertThat(firstBook.author().value().name().value(), equalTo("Divvya"));
		
		// TODO Login authentication security!
		// library.login();
		// library.loggedInUser() ?
		assertThat(library.users().isAvailable(), is(true));

	}

	
	public class TestLibraryImpl implements Library {

		boolean hasMadeBackEndAccess() {
			return false;
		}
		
		@Override
		public MultiReferenceList<Book> availableBooks() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MultiReferenceList<Author> allAuthors() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MultiReferenceList<User> users() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public OperationReturn<User> login() {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
