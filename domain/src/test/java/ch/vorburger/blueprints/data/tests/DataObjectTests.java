package ch.vorburger.blueprints.data.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ch.vorburger.blueprints.data.javareflect.JavaDataObjectFactory;
import ch.vorburger.blueprints.data.xmlxsd.XSDDataObjectFactory;

import commonj.sdo.DataObject;

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
		DataObject dataObject = f.create("http://schemas.vorburger.ch/formsample", "SampleFormType");
		dataObject.setString("name", "Saluton, Mondpacxo");
		assertThat(dataObject.getString("name"), equalTo("Saluton, Mondpacxo"));
		
		// assertThat f.getTypes() contains SampleFormType
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
		JavaDataObjectFactory f = new JavaDataObjectFactory();
		f.register(BookImpl.class);
		DataObject dataObject = f.create(Book.class.getPackage().getName(), Book.class.getSimpleName());
		assertThat(dataObject, is(notNullValue()));
		dataObject.setString("name", "Saluton, Mondpacxo");
		assertThat(dataObject.getString("name"), equalTo("Saluton, Mondpacxo"));
	}

	
	@Test
	public void testChain() {
		fail("Not yet implemented");
	}

}
