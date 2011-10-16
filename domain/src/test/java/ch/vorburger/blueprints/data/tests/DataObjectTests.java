package ch.vorburger.blueprints.data.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.javareflect.JavaDataObjectFactory;
import ch.vorburger.blueprints.data.meta.Type;
import ch.vorburger.blueprints.data.meta.TypesProvider;
import ch.vorburger.blueprints.data.xmlxsd.XSDDataObjectFactory;
import ch.vorburger.blueprints.objects.ObjectFactoryException;

/**
 * Tests.
 *
 * @author Michael Vorburger
 */
public class DataObjectTests {

	@Test
	public void testDynamicXSD() throws IOException {
		XSDDataObjectFactory f = new XSDDataObjectFactory();
		f.register("/SampleFormStructure.xsd");
		
		String sampleTypeURI = findURIContaining(f, "SampleFormType");
		DataObject dataObject = f.create(sampleTypeURI);
		dataObject.set("name", "Saluton, Mondpacxo");
		assertThat(dataObject.get("name", String.class), equalTo("Saluton, Mondpacxo"));
	}

	@Test
	public void testDynamicJava() throws ObjectFactoryException {
		JavaDataObjectFactory f = new JavaDataObjectFactory();
		f.register(BookImpl.class);

		String sampleTypeURI = findURIContaining(f, "Book");
		DataObject dataObject = f.create(sampleTypeURI);
		assertThat(dataObject, is(notNullValue()));
		dataObject.set("name", "Saluton, Mondpacxo");
		assertThat(dataObject.get("name", String.class), equalTo("Saluton, Mondpacxo"));
	}
	
	private String findURIContaining(TypesProvider f, String nameFragment) {
		List<Type> types = f.getTypes();
		assertTrue(types.size() > 3);
		for (Type type : types) {
			if (type.getURI().contains(nameFragment)) {
				return type.getURI();
			}
		}
		fail("Factory does not contain any Type with an URI containing " + nameFragment);
		return null;
	}


//	@Test(expected=UnsupportedOperationException.class)
//	public void testStaticXSD() {
//		DataObjectFactory f = new XSDDataObjectFactory();
//		f.create(Book.class);
//	}

// Would this really be needed, is there a use case for such a usage?!
//	@Test
//	public void testStaticJava() {
//		JavaDataObjectFactory f = new JavaDataObjectFactory();
//		f.register(BookImpl.class);
//		Book book = f.create(Book.class);
//		assertThat(book, is(notNullValue()));
//		book.setName("Saluton, Mondpacxo");
//		assertThat(book.getName(), equalTo("Saluton, Mondpacxo"));
//		
//		book = f.create(BookImpl.class);
//		assertThat(book, is(notNullValue()));
//	}
	
}
