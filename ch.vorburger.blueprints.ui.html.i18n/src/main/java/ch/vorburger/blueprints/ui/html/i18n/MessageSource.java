package ch.vorburger.blueprints.ui.html.i18n;

import java.util.Locale;

/**
 * Strategy for resolving messages.
 * 
 * Inspired by the Spring Framework's MessageSource, but duplicated in a simplified form here so that
 * this module does not have to depend on Spring. An Adapter to a Spring MessageSource implementation is
 * provided in another module.
 *
 * @author Michael Vorburger
 */
public interface MessageSource {

	String getMessage(String key, Locale locale);

	// TODO integrate a CMS-like live translation change in app (e.g. Ctrl-Click on Labels) 
	// boolean isMessageModifiable(String key);
	// void setMessage(String key, Locale locale, String message);
	
}
