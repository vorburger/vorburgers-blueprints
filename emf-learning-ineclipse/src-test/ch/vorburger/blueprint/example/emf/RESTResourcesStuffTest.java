package ch.vorburger.blueprint.example.emf;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import libraryinteractionmodel.Book;
import libraryinteractionmodel.Books;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;


/**
 * 
 * TODO Doc
 *
 * @author Kai Kreuzer & Michael Vorburger
 */
public class RESTResourcesStuffTest {

	@Test
	public void testRESTResources() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new RESTResourceFactoryImpl());
		
		ResourceSet rs = new ResourceSetImpl();
		rs.setURIConverter(new RESTURIConverter());

		URI uri = URI.createURI("/library/books/12345");
		Resource aBookResource = rs.createResource(uri);
		
		Book aBook = (Book) aBookResource.getContents().get(0);
		assertThat(aBook.getIsbn(), is(12345L));
		
		
// TODO /books - paging?!		
//		URI uri = URI.createURI("/library/books");
//		Resource booksResource = rs.createResource(uri);
//		
//		Books books = (Books) booksResource.getContents();
		
	}
}
