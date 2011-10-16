package ch.vorburger.blueprints.data.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.javareflect.JavaDataObjectFactory;
import ch.vorburger.blueprints.data.xmlxsd.XSDDataObjectFactory;

/**
 * Tests.
 *
 * @author Michael Vorburger
 */
public class DataObjectTests {

	@Test
	public void testDynamicXSD() throws IOException {
		// TODO First assertThat f.getTypes() contains SampleFormType, keep that Type, use getURI on it, and create using that!
		
		XSDDataObjectFactory f = new XSDDataObjectFactory();
		f.register("/SampleFormStructure.xsd");
		DataObject dataObject = f.create("http://schemas.vorburger.ch/formsample#SampleFormType");
		dataObject.set("name", "Saluton, Mondpacxo");
		assertThat(dataObject.get("name", String.class), equalTo("Saluton, Mondpacxo"));
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

	@Test
	public void testDynamicJava() {
		// TODO First assertThat f.getTypes() contains Book, keep that Type, use getURI on it, and create using that!

		JavaDataObjectFactory f = new JavaDataObjectFactory();
		f.register(BookImpl.class);
		DataObject dataObject = null; // f.create(Book.class.getPackage().getName(), Book.class.getSimpleName());
		assertThat(dataObject, is(notNullValue()));
		dataObject.set("name", "Saluton, Mondpacxo");
		assertThat(dataObject.get("name", String.class), equalTo("Saluton, Mondpacxo"));
	}

	
	@Test
	public void testChain() {
		fail("Not yet implemented");
	}

}
