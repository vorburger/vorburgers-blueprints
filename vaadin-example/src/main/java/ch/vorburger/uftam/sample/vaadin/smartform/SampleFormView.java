package ch.vorburger.uftam.sample.vaadin.smartform;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;

public class SampleFormView extends CustomComponent {

	@AutoGenerated
	private GridLayout mainLayout;
	@AutoGenerated
	private Button button_save;
	@AutoGenerated
	private Label label_1;
	@AutoGenerated
	private CheckBox checkBox_something;
	@AutoGenerated
	private OptionGroup optionGroup_stuff;
	@AutoGenerated
	private ComboBox comboBox_state;
	@AutoGenerated
	private PopupDateField popupDateField;
	@AutoGenerated
	private ComboBox comboBox_country;
	@AutoGenerated
	private TextField textField_amount;
	@AutoGenerated
	private ComboBox comboBox_colour;
	@AutoGenerated
	private TextField textField_name;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public SampleFormView() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	public GridLayout getMainLayout() {
		return mainLayout;
	}

	public Button getButton_save() {
		return button_save;
	}

	public Label getLabel_1() {
		return label_1;
	}

	public CheckBox getCheckBox_something() {
		return checkBox_something;
	}

	public OptionGroup getOptionGroup_stuff() {
		return optionGroup_stuff;
	}

	public ComboBox getComboBox_state() {
		return comboBox_state;
	}

	public PopupDateField getPopupDateField() {
		return popupDateField;
	}

	public ComboBox getComboBox_country() {
		return comboBox_country;
	}

	public TextField getTextField_amount() {
		return textField_amount;
	}

	public ComboBox getComboBox_colour() {
		return comboBox_colour;
	}

	public TextField getTextField_name() {
		return textField_name;
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("-1px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		mainLayout.setColumns(2);
		mainLayout.setRows(5);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("-1px");
		
		// textField_name
		textField_name = new TextField();
		textField_name.setCaption("Name:");
		textField_name.setImmediate(false);
		textField_name.setWidth("-1px");
		textField_name.setHeight("-1px");
		textField_name.setRequired(true);
		textField_name.setSecret(false);
		mainLayout.addComponent(textField_name, 0, 0);
		
		// comboBox_colour
		comboBox_colour = new ComboBox();
		comboBox_colour.setCaption("Colour:");
		comboBox_colour.setImmediate(false);
		comboBox_colour.setWidth("-1px");
		comboBox_colour.setHeight("-1px");
		mainLayout.addComponent(comboBox_colour, 1, 0);
		
		// textField_amount
		textField_amount = new TextField();
		textField_amount.setCaption("Amount:");
		textField_amount.setImmediate(true);
		textField_amount.setWidth("-1px");
		textField_amount.setHeight("-1px");
		textField_amount.setSecret(false);
		mainLayout.addComponent(textField_amount, 0, 1);
		
		// comboBox_country
		comboBox_country = new ComboBox();
		comboBox_country.setCaption("Country:");
		comboBox_country.setImmediate(false);
		comboBox_country.setWidth("-1px");
		comboBox_country.setHeight("-1px");
		mainLayout.addComponent(comboBox_country, 1, 1);
		
		// popupDateField
		popupDateField = new PopupDateField();
		popupDateField.setCaption("Date:");
		popupDateField.setEnabled(false);
		popupDateField.setImmediate(false);
		popupDateField.setWidth("-1px");
		popupDateField.setHeight("-1px");
		popupDateField.setInvalidAllowed(false);
		popupDateField.setResolution(4);
		mainLayout.addComponent(popupDateField, 0, 2);
		
		// comboBox_state
		comboBox_state = new ComboBox();
		comboBox_state.setCaption("State:");
		comboBox_state.setImmediate(false);
		comboBox_state.setWidth("-1px");
		comboBox_state.setHeight("-1px");
		mainLayout.addComponent(comboBox_state, 1, 2);
		
		// optionGroup_stuff
		optionGroup_stuff = new OptionGroup();
		optionGroup_stuff.setImmediate(false);
		optionGroup_stuff.setWidth("-1px");
		optionGroup_stuff.setHeight("-1px");
		mainLayout.addComponent(optionGroup_stuff, 0, 3);
		
		// checkBox_something
		checkBox_something = new CheckBox();
		checkBox_something.setCaption("Check something:");
		checkBox_something.setImmediate(false);
		checkBox_something.setWidth("-1px");
		checkBox_something.setHeight("-1px");
		mainLayout.addComponent(checkBox_something, 1, 3);
		
		// label_1
		label_1 = new Label();
		label_1.setCaption("Try: Amount > 100 enables Date, ... ");
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("Label");
		mainLayout.addComponent(label_1, 0, 4);
		
		// button_save
		button_save = new Button();
		button_save.setCaption("Save");
		button_save.setImmediate(true);
		button_save.setDescription("Button Tooltip Description");
		button_save.setWidth("-1px");
		button_save.setHeight("100.0%");
		button_save.setRequired(true);
		mainLayout.addComponent(button_save, 1, 4);
		mainLayout.setComponentAlignment(button_save, new Alignment(20));
		
		return mainLayout;
	}
	
}
