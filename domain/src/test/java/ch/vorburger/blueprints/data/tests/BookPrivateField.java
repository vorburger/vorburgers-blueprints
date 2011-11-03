package ch.vorburger.blueprints.data.tests;

import javax.annotation.Generated;

/**
 * Example/Test static Java Data Object with private field, no getter/setter accessors.
 *
 * @author Michael Vorburger
 */
public class BookPrivateField {

	@Generated("Just an example")
	private Name theName;

	public BookPrivateField() {
		super();
		this.theName = new Name();
		theName.setFirstName("Mickey");
		theName.setLastName("Mouse");
	}
}
