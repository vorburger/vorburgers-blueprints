package ch.vorburger.smartforms;

import commonj.sdo.DataObject;

/**
 * Controller for Smart Form.
 * 
 * @author Michael Vorburger
 */
public interface SmartFormController {


// TODO Remove, not needed...
//	/**
//	 * Initialize a Form.
//	 * 
//	 * @return FormDataObject, with empty ChangeSummary, but with additional information
//	 */
//	FormDataObject initForm(/* Map<String, Object> parameters */);
	
	/**
	 * Update a Form.
	 * 
	 * @param formDataWithChangeSummary DataObject with a ChangeSummary, never null
	 * @return FormDataObject, with empty ChangeSummary, but with additional information
	 */
	FormDataObject updateForm(DataObject formDataWithChangeSummary /* Map<String, Object> parameters */);
	
}
