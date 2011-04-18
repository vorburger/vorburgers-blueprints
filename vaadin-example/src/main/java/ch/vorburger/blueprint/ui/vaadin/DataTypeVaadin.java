package ch.vorburger.blueprint.ui.vaadin;

import com.vaadin.data.Validator;

import ch.vorburger.blueprint.common.data.DataType;

/**
 * @author Michael Vorburger
 */
public interface DataTypeVaadin extends DataType {

	Validator vaadinValidator();
	
}
