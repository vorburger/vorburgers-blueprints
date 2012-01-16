package ch.vorburger.blueprints.ui.html.i18n.tests.genidea;

import java.util.Locale;
import java.util.MissingResourceException;

/**
 * Inspired by GWT I18N.
 *
 * @author Michael Vorburger
 */
public class SampleGenMessages extends MessageThing {

	// TODO The Locale should, eventually, not be passed as an explicit argument, but injected as a ThreadLocal request scoped bean

	// TODO Write Unit Test Case!
	
/*
    TODO Write a DSL which translates this:
    
 	sample.messages (in a dedicated file, for shared translations; same syntax, without name, should also be usable in-line in another e.g. UI DSL)
		helloWorld = en:"Hello World", en_us: "Hehlo Woorld", eo: "Saluton!"
		badlogin(login: Login) = fr: "Mauvais Login pour utilisateur $login.uid!" // TODO Exact EL syntax TBD
		
	into this:
*/

	public String helloWorld(Locale locale) {
	    String msg = helloWorld_(locale);
	    if (msg == null) {
	    	msg = helloWorld_(defaultLocale);
	    	if (msg == null) {
		    	throw new MissingResourceException("Message helloWorld can't be found for Locale " + locale, SampleGenMessages.class.getName(), "helloWorld");
	    	}
	    }
	    return msg;
	}

	private String helloWorld_(Locale locale) {
		String language = locale.getLanguage();
	    String country = locale.getCountry();
	    // String variant = locale.getVariant();

	    if ("en".equals(language)) {
	    	if ("us".equals(country))
	    		return "Hehlo Woorld";
	    	return "Hello World";
	    } else if ("eo".equals(language))
	    	return "Saluton!";
	    
		return null;
	}
	
	
	public static class Login {
		public String uid;
	}

	public String badlogin(Locale locale, Login login) {
		return "Mauvais Login pour utilisateur " + login.uid + "!"; // TODO Use more efficient String concatenation than this?
	}
}
