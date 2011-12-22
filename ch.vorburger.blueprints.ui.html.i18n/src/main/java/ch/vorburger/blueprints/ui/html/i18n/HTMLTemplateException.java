package ch.vorburger.blueprints.ui.html.i18n;

/**
 * Exception for HTMLTemplate parsing/processing. 
 *
 * @author Michael Vorburger
 */
public class HTMLTemplateException extends Exception {

	public HTMLTemplateException(String message, Throwable cause) {
		super(message, cause);
	}

	public HTMLTemplateException(String message) {
		super(message);
	}

}
