package ch.vorburger.blueprints.data.tests;

/**
 * Book with a self-reference.
 *
 * @author Michael Vorburger
 */
public class BookWithBook extends BookImpl {
	
	private BookWithBook previousEditionBook;

	public BookWithBook getPreviousEditionBook() {
		return previousEditionBook;
	}

	public void setPreviousEditionBook(BookWithBook previousEditionBook) {
		this.previousEditionBook = previousEditionBook;
	}
	
}
