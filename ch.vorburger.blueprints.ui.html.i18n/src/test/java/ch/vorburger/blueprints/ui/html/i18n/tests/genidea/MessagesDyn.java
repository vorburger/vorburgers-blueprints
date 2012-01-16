package ch.vorburger.blueprints.ui.html.i18n.tests.genidea;

import java.util.Locale;

public class MessagesDyn extends MessageThing {
	// TODO Better class name...

	protected static interface MessageParameters {
		Object get(String name);
	}
	
	protected static interface MessageClosure<T> {
		T get(Locale locale, MessageParameters params);
	}
}
