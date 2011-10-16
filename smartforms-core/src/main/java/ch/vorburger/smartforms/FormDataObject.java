package ch.vorburger.smartforms;

import java.util.List;

import commonj.sdo.DataObject;

/**
 * DataObject which has details required for form editing.
 * 
 * @author Michael Vorburger
 */
public class FormDataObject {

	// TODO Add more stuff... e.g. floating point digit limitation, max string size, etc.
	
	// TODO Better full JavaDoc
	
	// The names here must match the ones of the property attributes in smartform.xsd 
	private static final String ACTIVE = "active";
//	private static final String LABEL = "label";
	private static final String REQUIRED = "required";
	private static final String ERROR_MSG = "errrorMessage";
	// TODO? private static final String CHOICES = "choices";
	
	private final static FormDetailsHelper HELPER = new FormDetailsHelper();

	private final DataObject data;

	/**
	 * Constructor.
	 * @param data DataObject (never null)
	 */
	public FormDataObject(DataObject data) {
		super();
		if (data == null) {
			throw new IllegalArgumentException("data can not be null");
		}
		if (!data.getType().isOpen()) {
			throw new IllegalArgumentException(data.getType().getName() + " is not open");
		}
		this.data = data;
	}

	/**
	 * Get Data. 
	 * @return {@link DataObject} holding the actual form field (property) data
	 */
	public DataObject getData() {
		return data;
	}
	
	public boolean isActive(String path) {
		return HELPER.getBooleanFormDetailsAttribute(data, path, ACTIVE);
	}
	public void setActive(String path, boolean isActive) {
		HELPER.setBooleanFormDetailsAttribute(data, path, ACTIVE, isActive);
	}
	
//	/**
//	 * 
//     * @param path the path to a valid object and property.
//	 * @return label to be displayed to end-user for property
//	 */
//	public String getLabel(String path) {
//		return HELPER.getStringFormDetailsAttribute(data, path, LABEL);
//	}
//	public void setLabel(String path, String label) {
//		HELPER.setStringFormDetailsAttribute(data, path, LABEL, label);
//	}
	
	public boolean isRequired(String path) {
		return HELPER.getBooleanFormDetailsAttribute(data, path, REQUIRED);
	}
	public void setRequired(String path, boolean isRequired) {
		HELPER.setBooleanFormDetailsAttribute(data, path, REQUIRED, isRequired);
	}
	
	/**
	 * 
     * @param path the path to a valid object and property.
	 * @return Message, or null if field is valid
	 */
	public String getErrorMessage(String path) {
		return HELPER.getStringFormDetailsAttribute(data, path, ERROR_MSG);
	}
	
	/**
	 * Set the Error Message
	 * @param path the path to a valid object and property.
	 * @param errorMessage, or null to unset the Error Message
	 */
	public void setErrorMessage(String path, String errorMessage) {
		HELPER.setStringFormDetailsAttribute(data, path, ERROR_MSG, errorMessage);
	}
	
	// TODO @SuppressWarnings("unchecked")
	public List<DataObject> getChoices(String path) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	public void setChoices(String path, List<DataObject> choices) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
}
