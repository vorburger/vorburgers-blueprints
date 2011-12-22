package ch.vorburger.blueprints.ui.html.i18n.tests;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * SAX Error Handler (only) for Tests.
 *
 * @author Michael Vorburger
 */
public class ErrorHandler implements org.xml.sax.ErrorHandler {

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		exception.printStackTrace();
		throw new SAXException("Boo", exception);

	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		exception.printStackTrace();
		throw new SAXException("Boo", exception);
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		exception.printStackTrace();
		throw new SAXException("Boo", exception);
	}

}
