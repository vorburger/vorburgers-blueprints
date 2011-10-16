package ch.vorburger.smartforms.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.junit.Before;
import org.junit.Test;

import ch.vorburger.smartforms.FormDataObject;
import ch.vorburger.smartforms.SmartFormController;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Tests for SmartFormController.
 * 
 * @author Michael Vorburger
 */
public class SmartFormControllerTest {

    private HelperContext sdoContext = SDOUtil.createHelperContext();

    @Before
    public void setUp() throws Exception {
    	SDOTestHelpers.loadTypesFromXMLSchemaFile(sdoContext, "/SampleFormStructure.xsd");
    }
	
	@Test
	public void testSampleForm() {
		DataObject initialData = sdoContext.getDataFactory().create(TestConstants.NS, "SampleFormType");
		SmartFormController c = new TestSmartFormControllerImpl();
		
		// TODO Rewrite the asserts below using Hamcrest and custom matchers in nice "fluent" style
		
		// Assert that everything is empty in the beginning
		assertFieldIsNull(initialData, "name");
		assertFieldIsNull(initialData, "amount");
		assertFieldIsNull(initialData, "date");
		assertFieldIsNull(initialData, "colour");
		assertFieldIsNull(initialData, "country");
		assertFieldIsNull(initialData, "state");
		assertFieldIsNull(initialData, "customer");

		// Initially, Form is empty, but has some required field validation errors
		FormDataObject formData = c.updateForm(initialData);
		assertTrue(formData.isActive("name"));
		assertTrue(formData.isRequired("name"));
		assertNotNull(formData.getErrorMessage("name"));
		// Amount & Colour are inactive for an empty form:
		assertFalse(formData.isActive("amount"));
		assertFalse(formData.isActive("colour"));
				
		// Next, name is set, so validation error is gone
		formData.getData().setString("name", "Hello World");
		formData = c.updateForm(formData.getData());
		assertNull(formData.getErrorMessage("name"));
		// Amount is active when name is set:
		assertTrue(formData.isActive("amount"));

		// Error message comes back if name is reset (empty) again:
		formData.getData().setString("name", null);
		formData = c.updateForm(formData.getData());
		assertNotNull(formData.getErrorMessage("name"));
		assertFalse(formData.isActive("amount"));

		// Amount & Colour are again/still inactive now:
		assertFalse(formData.isActive("colour"));
		assertFalse(formData.isActive("amount"));

		// Setting amount (inactive! as name is still unset) is, intentionally, cleared out:
		formData.getData().setBigDecimal("amount", new BigDecimal(1));
		formData = c.updateForm(formData.getData());
		assertNull(formData.getData().getBigDecimal("amount"));
		
		// Next, set amount to an invalid value
		formData.getData().setBigDecimal("amount", new BigDecimal(1000000));
		formData = c.updateForm(formData.getData());
		assertNotNull(formData.getErrorMessage("amount"));
		assertFalse(formData.isActive("colour"));
		
		// Now set amount to a valid value
		formData.getData().setBigDecimal("amount", new BigDecimal(123.45));
		formData = c.updateForm(formData.getData());
		assertNull(formData.getErrorMessage("amount"));
		
		// Now Colour has become active
		assertTrue(formData.isActive("colour"));
		assertEquals(2, formData.getChoices("colour").size());
		
		// Watch this: If the amount is > 1000, a third colour choice is available!
		formData.getData().setBigDecimal("amount", new BigDecimal(1234));
		formData = c.updateForm(formData.getData());
		assertEquals(3, formData.getChoices("colour").size());
		
		// TODO More sample logic: fail("Not yet fully implemented");
	}
	
	private void assertFieldIsNull(DataObject data, String path) {
		assertNull(data.get(path));
	}

}
