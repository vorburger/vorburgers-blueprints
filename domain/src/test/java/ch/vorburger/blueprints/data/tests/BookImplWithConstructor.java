package ch.vorburger.blueprints.data.tests;


/**
 * Example/Test static Java Data Object implementation which does NOT have a No-Arg Constructor.
 *
 * @author Michael Vorburger
 */
public class BookImplWithConstructor extends BookImpl {

	public BookImplWithConstructor(boolean justSomeArgToAvoidNoArgConstructor) {
		super();
	}

}
