package ch.vorburger.blueprint.interactionframework.resources.uri;

import java.net.URISyntaxException;

/**
 * URIFactory for JavaNetURI.
 * 
 * @author Michael Vorburger
 */
public class JavaNetURIFactory implements URIFactory {

	@Override
	public URI parse(String uriString) throws IllegalArgumentException {
		try {
			java.net.URI javaNetURI = new java.net.URI(uriString);
			return new JavaNetURI(javaNetURI);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("JavaNetURIFactory cannot parse: " + uriString, e);
		}
	}

}
