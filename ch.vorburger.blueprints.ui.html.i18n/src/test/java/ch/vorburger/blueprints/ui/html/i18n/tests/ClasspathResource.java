package ch.vorburger.blueprints.ui.html.i18n.tests;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import ch.vorburger.blueprints.ui.html.i18n.Resource;

/**
 * Resource from Classpath.
 * 
 * Currently intended for Unit Tests only;
 * real-world would use Spring Framework Resource implementation adapter.
 *
 * @author Michael Vorburger
 */
public class ClasspathResource implements Resource {

	private final String resourceName;

	public ClasspathResource(String resourceName) {
		super();
		this.resourceName = resourceName;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		InputStream is = getClass().getResourceAsStream(resourceName);
		assertNotNull(is);
		return is;
	}

	/**
	 * Dummy implementation, always returns 0.
	 */
	@Override
	public long lastModified() throws IOException {
		return 0;
	}

	@Override
	public String getDescription() {
		throw new UnsupportedOperationException();
	}

}
