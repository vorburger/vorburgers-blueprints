package ch.vorburger.blueprint.example.emf;

import libraryinteractionmodel.Book;
import libraryinteractionmodel.LibraryinteractionmodelFactory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * TODO Doc
 *
 * @author Kai Kreuzer & Michael Vorburger
 */
public class SampleMemoryResourceImpl extends ResourceImpl {

	public SampleMemoryResourceImpl(URI uri) {
		super(uri);
		
		Book book = LibraryinteractionmodelFactory.eINSTANCE.createBook();
		book.setIsbn(Long.valueOf(uri.lastSegment()));
		book.setTitle("A Book named... uh, say " + book.getIsbn());
		
		getContents().add(book);
	}

}
