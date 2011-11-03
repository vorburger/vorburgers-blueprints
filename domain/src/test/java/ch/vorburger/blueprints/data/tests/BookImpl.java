package ch.vorburger.blueprints.data.tests;

/**
 * Example/Test static Java Data Object implementation.
 *
 * @author Michael Vorburger
 */
public class BookImpl implements Book {

	private String _name;

	@Override
	public String getAName() {
		return this._name;
	}

	@Override
	public void setAName(String name) {
		this._name = name;
	}

}
