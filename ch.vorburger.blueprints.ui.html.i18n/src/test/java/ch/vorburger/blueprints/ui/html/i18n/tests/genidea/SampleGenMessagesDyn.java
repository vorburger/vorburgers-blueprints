package ch.vorburger.blueprints.ui.html.i18n.tests.genidea;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

/**
 * Dyn. variant of SampleGenMessages.
 * 
 * @see SampleGenMessages
 *
 * @author Michael Vorburger
 */
public class SampleGenMessagesDyn extends MessagesDyn {

	// TODO Not sure if this whole approach makes any sense/if of any use... may delete later again
	
	private Map<String, MessageClosure<String>> map = new HashMap<String, MessagesDyn.MessageClosure<String>>();
	
	public SampleGenMessagesDyn() {
		map.put("helloWorld", helloWorld);
	}
	
	public String getMessage(String key, MessageParameters args, Locale locale) {
	    String msg = map.get(key).get(locale, args);
	    if (msg == null) {
	    	msg = map.get(key).get(defaultLocale, args);
	    	if (msg == null) {
		    	throw new MissingResourceException("Message " + key + " can't be found for Locale " + locale, SampleGenMessagesDyn.class.getName(), "helloWorld");
	    	}
	    }
	    return msg;
	}
	
	private static MessageClosure<String> helloWorld = new MessageClosure<String>() {
		@Override
		public String get(Locale locale, MessageParameters args) {
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
	};

	public String helloWorld(Locale locale) {
	    String msg = helloWorld_(locale);
	    if (msg == null) {
	    	msg = helloWorld_(defaultLocale);
	    	if (msg == null) {
		    	throw new MissingResourceException("Message helloWorld can't be found for Locale " + locale, SampleGenMessagesDyn.class.getName(), "helloWorld");
	    	}
	    }
	    return msg;
	}

	private String helloWorld_(Locale locale) {
		return helloWorld.get(locale, null);
	}
	
	
	public static class Login {
		public String uid;
	}

	private static MessageClosure<String> badlogin = new MessageClosure<String>() {
		@Override
		public String get(Locale locale, MessageParameters params) {
			// TODO Use more efficient String concatenation than this?
			return "Mauvais Login pour utilisateur " + ((Login)params.get("login")).uid + "!";
		}
	};
	
	public String badlogin(Locale locale, final Login login) {
		return badlogin.get(locale, new MessageParameters() {
			@Override
			public Object get(String name) {
				if ("login".equals(name))
					return login;
				else
					throw new IllegalArgumentException(name);
			}
		});
	}
}
