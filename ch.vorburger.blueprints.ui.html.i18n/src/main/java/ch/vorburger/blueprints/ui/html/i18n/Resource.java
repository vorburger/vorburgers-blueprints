package ch.vorburger.blueprints.ui.html.i18n;

import java.io.InputStream;

/**
 * Resource.
 * 
 * Inspired by the Spring Framework's Resource, but duplicated in a simplified form here so that
 * this module does not have to depend on Spring. An Adapter to a Spring Resource implementation is
 * provided in another module.
 * 
 * @author Michael Vorburger
 */
public interface Resource {

	InputStream getInputStream() throws java.io.IOException;

	long lastModified() throws java.io.IOException;

	String getDescription();
	
}
