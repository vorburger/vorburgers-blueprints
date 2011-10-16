package ch.vorburger.smartforms.tests;

import static org.junit.Assert.*;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.junit.Test;

import ch.vorburger.smartforms.FormDataObject;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Tests the FormDataObject.
 * 
 * @author Michael Vorburger
 */
public class FormDataObjectTest {

	@Test
	public void testFormDataObject() throws Exception {
		HelperContext sdoContext = SDOUtil.createHelperContext();
		SDOTestHelpers.loadTypesFromXMLSchemaFile(sdoContext, "/SampleFormStructure.xsd");
		DataObject dataObject = sdoContext.getDataFactory().create(TestConstants.NS, "SampleFormType");
		dataObject.setString("name", "Saluton, Mondpacxo");
		
		FormDataObject formDataObject = new FormDataObject(dataObject);
		assertEquals("Saluton, Mondpacxo", formDataObject.getData().getString("name"));
		
		assertFalse(formDataObject.isActive("name"));
		formDataObject.setActive("name", true);
		assertTrue(formDataObject.isActive("name"));

		assertFalse(formDataObject.isRequired("name"));
		formDataObject.setRequired("name", true);
		assertTrue(formDataObject.isRequired("name"));

//		assertTrue(formDataObject.getLabel("name") == null);
//		formDataObject.setLabel("name", "Name:");
//		assertEquals("Name:", formDataObject.getLabel("name"));

		assertTrue(formDataObject.getErrorMessage("name") == null);
		formDataObject.setErrorMessage("name", "Too Long, and anyway I'm grumpy; fix it");
		assertEquals("Too Long, and anyway I'm grumpy; fix it", formDataObject.getErrorMessage("name"));

	}
	
}
