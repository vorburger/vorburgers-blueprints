package ch.vorburger.smartforms;

import java.io.IOException;
import java.util.List;

import org.apache.tuscany.sdo.api.SDOUtil;

import ch.vorburger.smartforms.tests.SDOTestHelpers;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.helper.HelperContext;

/**
 * Helper to manage "Form Details".
 * 
 * @author Michael Vorburger
 */
class FormDetailsHelper {

	// TODO Use Code Generation of smartform.xsd and static typing to simplify the understanding (and perf?) of this? 

	private static final String SMARTFORMS_XSD = "/smartform.xsd";
	
	private HelperContext sdoContext = SDOUtil.createHelperContext();
	
	/**
	 * This is the SDO Property representing Form Details.
	 */
	private Property formDetailsProperty;
	
	void setBooleanFormDetailsAttribute(DataObject dataObject, String propertyPath, String attributeName, boolean b) {
		DataObject formDetailsField = getFormFieldDetails(dataObject, propertyPath);
		formDetailsField.setBoolean(attributeName, b);
	}

	boolean getBooleanFormDetailsAttribute(DataObject dataObject, String propertyPath, String attributeName) {
		DataObject formDetailsField = getFormFieldDetails(dataObject, propertyPath);
		return formDetailsField.getBoolean(attributeName);
	}
	
	boolean isFormDetailsAttributeSet(DataObject dataObject, String propertyPath, String attributeName) {
		DataObject formDetailsField = getFormFieldDetails(dataObject, propertyPath);
		return formDetailsField.isSet(attributeName);
	}

	public String getStringFormDetailsAttribute(DataObject dataObject, String propertyPath, String attributeName) {
		DataObject formDetailsField = getFormFieldDetails(dataObject, propertyPath);
		return formDetailsField.getString(attributeName);
	}
	
	public void setStringFormDetailsAttribute(DataObject dataObject, String propertyPath, String attributeName, String value) {
		DataObject formDetailsField = getFormFieldDetails(dataObject, propertyPath);
		formDetailsField.setString(attributeName, value);
	}
	
	@SuppressWarnings("unchecked")
	private DataObject getFormFieldDetails(DataObject dataObject, String propertyPath) {
		if (dataObject == null || propertyPath == null) {
			throw new IllegalArgumentException("null dataObject or propertyPath argument not allowed");
		}
		List<DataObject> formDetailsList = dataObject.getList(getFormDetailsProperty());
		DataObject formDetails;
		if (formDetailsList.size() == 0) {
			formDetails = sdoContext.getDataFactory().create(getFormDetailsProperty().getType());
			formDetailsList.add(formDetails);
		} else {
			formDetails = formDetailsList.get(0);
		}
		DataObject formDetailsField = formDetails.getDataObject("property[path=" + propertyPath + "]");
		if (formDetailsField == null) {
			formDetailsField = formDetails.createDataObject("property");
			formDetailsField.setString("path", propertyPath);
		}
		return formDetailsField;
	}

	private Property getFormDetailsProperty() {
		if (formDetailsProperty == null) {
			try {
				SDOTestHelpers.loadTypesFromXMLSchemaFile(sdoContext, SMARTFORMS_XSD);
			} catch (IOException e) {
				throw new RuntimeException("Configuration problem, not able to find/load on/from classpath the " + SMARTFORMS_XSD, e);
			}
			formDetailsProperty = sdoContext.getTypeHelper().getOpenContentProperty("http://schemas.vorburger.ch/smartform", "form");
			if (formDetailsProperty == null) {
				throw new RuntimeException("Configuration problem, not able to find SDP Property");
			}
		}
		return formDetailsProperty;
	}

}
