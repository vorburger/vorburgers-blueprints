package ch.vorburger.blueprints.data.tests;

/**
 * Example/Test static Java Data Object implementation.
 *
 * @author Michael Vorburger
 */
public class BookImpl implements Book {

	private String name;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
