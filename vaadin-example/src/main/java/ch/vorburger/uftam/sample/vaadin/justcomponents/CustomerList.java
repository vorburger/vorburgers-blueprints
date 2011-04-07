package ch.vorburger.uftam.sample.vaadin.justcomponents;

import ch.vorburger.blueprint.ui.vaadin.Table;
import ch.vorburger.uftam.sample.model.domain.Customer;

/**
 * List of Customers.
 * 
 * @author Michael Vorburger
 */
@SuppressWarnings("serial")
public class CustomerList extends Table<Customer> {
	// TODO CssLayout?

	public CustomerList() {
		super();
		setCaption("Customers"); // TODO ?
	}

	@Override
	protected void configureAfterSetModel() {
		setVisibleColumns(new Object[] { "id", "name" });
	}

}
