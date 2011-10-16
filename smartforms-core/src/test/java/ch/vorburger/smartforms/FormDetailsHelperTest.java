package ch.vorburger.smartforms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.junit.Test;

import ch.vorburger.smartforms.tests.SDOTestHelpers;
import ch.vorburger.smartforms.tests.TestConstants;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Tests the FormDetailsHelper.
 * 
 * @author Michael Vorburger
 */
public class FormDetailsHelperTest {

	@Test
	public void testFormDetailsHelper() throws Exception {
		HelperContext sdoContext = SDOUtil.createHelperContext();
		SDOTestHelpers.loadTypesFromXMLSchemaFile(sdoContext, "/SampleFormStructure.xsd");
		DataObject dataObject = sdoContext.getDataFactory().create(TestConstants.NS, "SampleFormType");
		dataObject.setString("name", "Saluton, Mondpacxo");
		
		assertTrue(dataObject.getType().isOpen());
		FormDetailsHelper helper = new FormDetailsHelper();
		helper.setBooleanFormDetailsAttribute(dataObject, "patientSpeaksEsperanto", "active", false);
		System.out.println(sdoContext.getXMLHelper().save(dataObject, "SOME-NS", "test"));
		helper.setBooleanFormDetailsAttribute(dataObject, "patientSpeaksEsperanto", "active", true);
		assertTrue(helper.isFormDetailsAttributeSet(dataObject, "patientSpeaksEsperanto", "active"));
		assertTrue(helper.getBooleanFormDetailsAttribute(dataObject, "patientSpeaksEsperanto", "active"));
		assertFalse(helper.isFormDetailsAttributeSet(dataObject, "patientSpeaksEsperanto", "somethingElse"));
		// WON'T WORK, good: helper.setBooleanFormDetailsAttribute(dataObject, "patientSpeaksEsperanto", "somethingElse", true);
	}

}
