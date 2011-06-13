package ch.vorburger.blueprint.interactionframework.resources.uri.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import ch.vorburger.blueprint.interactionframework.resources.uri.JavaNetURIFactory;
import ch.vorburger.blueprint.interactionframework.resources.uri.URI;

/**
 * Tests for the URI stuff.
 * 
 * @author Michael Vorburger
 */
public class URITest {

	@Test
	public void testURIs() {
		URI.Factory.add(new JavaNetURIFactory());
		
		URI uri = URI.Factory.parse("http://www.google.com");
		assertThat(uri.toString(), equalTo("http://www.google.com"));
	}
}
