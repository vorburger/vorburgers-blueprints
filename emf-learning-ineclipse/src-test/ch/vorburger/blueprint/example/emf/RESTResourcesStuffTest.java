package ch.vorburger.blueprint.example.emf;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import libraryinteractionmodel.Author;
import libraryinteractionmodel.AuthorShort;
import libraryinteractionmodel.Book;
import libraryinteractionmodel.Books;
import libraryinteractionmodel.impl.AuthorImpl;
import libraryinteractionmodel.impl.AuthorShortImpl;
import libraryinteractionmodel.impl.AuthorsImpl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * TODO Doc
 *
 * @author Kai Kreuzer & Michael Vorburger
 */
public class RESTResourcesStuffTest {

	private static ResourceSet rs;
	
	@BeforeClass
	public static void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new RESTResourceFactoryImpl());
		rs = new ResourceSetImpl();
		rs.setURIConverter(new RESTURIConverter());
	}

	@Test
	public void testGetBookAndItsLinkedAuthor() {
		URI aBookURI = URI.createURI("/library/books/12345");
		Resource aBookResource = rs.getResource(aBookURI, true);
		Book aBook = (Book) aBookResource.getContents().get(0);
		assertThat(aBook.getIsbn(), is(12345L));
		
		// This is "embedded", so full object already
		AuthorShort authorShort = aBook.getAuthor();
		assertThat(authorShort.eIsProxy(), is(false));
		assertThat(authorShort.getName(), equalTo("Disney"));
		
		// This is a "link" - so only a reference (for now)
		Author authorProxy = ((AuthorShortImpl) authorShort).basicGetSelf();
		// NOTE: Instead of *Impl cast, could also use eGet(..., false); 
		assertThat(authorProxy.eIsProxy(), is(true));
		
		Author author = authorShort.getSelf();
		assertThat(author.getName(), equalTo("Disney"));
		assertThat(author.getFullBio(), equalTo("Disney was born..."));
		assertThat(author.eIsProxy(), is(false));
	}
	
	@Test
	public void testGetBooks() {
		URI uri = URI.createURI("/library/books?start=1&size=20");
		Resource booksResource = rs.createResource(uri);
		Books books = (Books) booksResource.getContents().get(0);
		assertThat(books.getItems().size(), is(20));
		assertThat(books.getItems().get(1).getIsbn() * 1000, is(2000L));
	}
}
