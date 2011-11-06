package ch.vorburger.blueprints.data.tests;

/**
 * Example/Test static Java Data Object implementation.
 *
 * @author Michael Vorburger
 */
public class BookImpl implements Book {

	private String _name;

	// Intentionally no constructor, so uses default no-args constructor
	
	@Override
	public String getAName() {
		return this._name;
	}

	@Override
	public void setAName(String name) {
		this._name = name;
	}

}
