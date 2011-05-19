package ch.vorburger.blueprint.example.emf;

import java.io.IOException;
import java.util.Map;

import libraryinteractionmodel.Author;
import libraryinteractionmodel.AuthorShort;
import libraryinteractionmodel.Book;
import libraryinteractionmodel.LibraryinteractionmodelFactory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * TODO Doc
 * 
 * @author Kai Kreuzer & Michael Vorburger
 */
public class SampleMemoryResourceImpl extends ResourceImpl {

	public SampleMemoryResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		if (!isLoaded) {
			// TODO URI to Resource mapping, dynamically (from Annotation in model? Automagically
			// derived from Model?)
			if (getURI().path().startsWith("/library/books/")) {
				Book book = LibraryinteractionmodelFactory.eINSTANCE.createBook();
				book.setIsbn(Long.valueOf(uri.lastSegment()));
				book.setTitle("A Book named... uh, say " + book.getIsbn());
				getContents().add(book);
				AuthorShort authorShort = LibraryinteractionmodelFactory.eINSTANCE.createAuthorShort();
				authorShort.setName("Disney");
				Author authorProxy = LibraryinteractionmodelFactory.eINSTANCE.createAuthor();
				InternalEObject authorProxyInternal = (InternalEObject) authorProxy;
				URI authorURI = URI.createURI("/library/authors/678"); 
				authorProxyInternal.eSetProxyURI(authorURI);
				authorShort.setSelf(authorProxy);
				book.setAuthor(authorShort);
			} else if (getURI().path().startsWith("/library/authors/")) {
				Author author = LibraryinteractionmodelFactory.eINSTANCE.createAuthor();
				author.setName("Disney");
				author.setFullBio("Disney was born...");
				getContents().add(author);
			} else if (getURI().path().startsWith("/library/books")) {
				throw new UnsupportedOperationException();
				// TODO !!!!
			} else {
				// TODO Error handling? see super()...
			}
		}
	}

	@Override
	public EObject getEObject(String uriFragment) {
		return getContents().get(0);
	}
	
	
}
