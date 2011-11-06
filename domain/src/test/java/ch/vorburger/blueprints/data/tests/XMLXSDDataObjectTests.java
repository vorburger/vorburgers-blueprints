package ch.vorburger.blueprints.data.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.meta.Type;
import ch.vorburger.blueprints.data.meta.TypesProvider;
import ch.vorburger.blueprints.data.xmlxsd.XSDDataObjectFactory;

/**
 * Tests for XSDDataObjectFactory.
 *
 * @author Michael Vorburger
 */
public class XMLXSDDataObjectTests {

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


//	@Test(expected=UnsupportedOperationException.class)
//	public void testStaticXSD() {
//		DataObjectFactory f = new XSDDataObjectFactory();
//		f.create(Book.class);
//	}

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


}
