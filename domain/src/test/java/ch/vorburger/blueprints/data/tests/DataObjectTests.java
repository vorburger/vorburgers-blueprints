package ch.vorburger.blueprints.data.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.javareflect.JavaDataObjectFactory;
import ch.vorburger.blueprints.data.meta.Property;
import ch.vorburger.blueprints.data.meta.Type;
import ch.vorburger.blueprints.data.meta.TypesProvider;
import ch.vorburger.blueprints.data.xmlxsd.XSDDataObjectFactory;
import ch.vorburger.blueprints.objects.ObjectFactoryException;

/**
 * Tests for DataObject & DataObjectFactory implementations.
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
		
		Type type = f.getTypes().get(sampleTypeURI);
		assertEquals(8, type.getProperties().size());
	}

	@Test
	public void testLeafSimpleTypes() throws ObjectFactoryException {
		JavaDataObjectFactory f = new JavaDataObjectFactory();
		Type stringType = f.register(String.class);
		assertNull(stringType.getProperties());
		assertEquals(String.class, stringType.getInstanceClass());
	}
	
	@Test
	public void testStaticJavaBean() throws ObjectFactoryException {
		JavaDataObjectFactory f = new JavaDataObjectFactory();
		f.register(BookImpl.class);

		String sampleTypeURI = findURIContaining(f, "Book");
		DataObject dataObject = f.create(sampleTypeURI);
		assertThat(dataObject, is(notNullValue()));
		dataObject.set("AName", "Saluton, Mondpacxo");
		assertThat(dataObject.get("AName", String.class), equalTo("Saluton, Mondpacxo"));
		
		Type type = f.getTypes().values().iterator().next();
		assertEquals(1, type.getProperties().size());
		assertEquals("AName", type.getProperties().iterator().next().getName());
		assertEquals(String.class, type.getProperties().iterator().next().getType().getInstanceClass());
	}

	@Test
	public void testStaticJavaPrivateProperty() throws ObjectFactoryException {
		JavaDataObjectFactory f = new JavaDataObjectFactory();
		f.register(BookPrivateField.class);
		
		Type type = f.getTypes().get("java:" + BookPrivateField.class.getName());
		List<Property> properties = type.getProperties();
		assertEquals(1, properties.size());
		assertEquals("theName", properties.get(0).getName());
		assertEquals("java:" + Name.class.getName(), properties.get(0).getType().getURI());
		assertEquals(2, properties.get(0).getType().getProperties().size());
		
		DataObject dataObject = f.create(type);
		assertNotNull(dataObject);
		DataObject nameDataObject = dataObject.get("theName", DataObject.class);
		assertEquals("Mickey", nameDataObject.get("firstName", String.class));
		
		nameDataObject.set("firstName", "Michael");
		assertEquals("Michael", nameDataObject.get("firstName", String.class));
	}

	
	private String findURIContaining(TypesProvider f, String nameFragment) {
		Map<String, ? extends Type> types = f.getTypes();
		for (Type type : types.values()) {
			if (type.getURI().contains(nameFragment)) {
				return type.getURI();
			}
		}
		fail("Factory does not contain any Type with an URI containing " + nameFragment + ", only: " + f.getTypes().keySet());
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
