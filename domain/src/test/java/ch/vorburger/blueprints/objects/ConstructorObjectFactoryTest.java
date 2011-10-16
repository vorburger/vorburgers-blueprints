package ch.vorburger.blueprints.objects;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ch.vorburger.blueprints.data.tests.Book;
import ch.vorburger.blueprints.data.tests.BookImpl;

/**
 * Unit Test for ConstructorObjectFactory.
 *
 * @author Michael Vorburger
 */
public class ConstructorObjectFactoryTest {

	@Test
	public void testGetObject() throws ObjectFactoryException {
		ObjectFactory<BookImpl> of = new ConstructorObjectFactory<BookImpl>(BookImpl.class);
		BookImpl obj = of.getObject();
		assertThat(obj, is(notNullValue()));
	}

	@Test(expected=ObjectFactoryException.class)
	public void testInterface() throws ObjectFactoryException {
		new ConstructorObjectFactory<Book>(Book.class);
	}

}
