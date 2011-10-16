package ch.vorburger.smartforms.tests;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import commonj.sdo.DataObject;
import commonj.sdo.Property;

import ch.vorburger.smartforms.FormDataObject;
import ch.vorburger.smartforms.SmartFormController;

/**
 * Example SmartFormController implementation, for SmartFormControllerTest.
 * 
 * @author Michael Vorburger
 */
public class TestSmartFormControllerImpl implements SmartFormController {

	@Override
	public FormDataObject updateForm(DataObject formDataWithChangeSummary) {
		FormDataObject form = new FormDataObject(formDataWithChangeSummary);
		
		// TODO Re-implement the logic hard-coded below through scripting!
		// Loop over all properties (name, amount, ...) and set all form attributes (active, required, ...) 
		
		form.setActive("name", true);
		form.setRequired("name", true);
		if (StringUtils.isBlank(form.getData().getString("name"))) {
			form.setErrorMessage("name", "Name is required!");
		} else {
			form.setErrorMessage("name", null);
		}
		
		form.setActive("amount", !StringUtils.isBlank(form.getData().getString("name")));
		form.setRequired("amount", !StringUtils.isBlank(form.getData().getString("name")));
		if (ObjectUtils.compare(form.getData().getBigDecimal("amount"), new BigDecimal(1000)) == 1) {
			form.setErrorMessage("amount", "Amount must be smaller than or equal to 1000");
		} else {
			form.setErrorMessage("amount", null);
		}
		
		// Colour is active if amount is not null, and not 0, and a valid amount (> 1000; so no error message)
		form.setActive("colour", form.getData().getBigDecimal("amount") != null
				&& StringUtils.isBlank(form.getErrorMessage("amount")));
		form.setRequired("colour", false);

		unsetInactiveFields(form);
		return form;
	}

	@SuppressWarnings("unchecked")
	private void unsetInactiveFields(FormDataObject form) {
		// Use type.properties and not instanceProperties here!
		// Because else it would include & blow away the formDetailsProperty (see FormDetailsHelper)
		List<Property> properties = form.getData().getType().getProperties();
		for (Property property : properties) {
			if (!form.isActive(property.getName())) {
				form.getData().unset(property);
			}
		}
	}

	// TODO Before saving, make sure everything isRequired is set?

	
}
