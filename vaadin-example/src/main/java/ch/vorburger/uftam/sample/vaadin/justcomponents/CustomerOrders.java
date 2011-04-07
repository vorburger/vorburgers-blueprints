package ch.vorburger.uftam.sample.vaadin.justcomponents;

import java.util.Set;

import ch.vorburger.blueprint.ui.vaadin.Table;
import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.Order;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * View showing a list of Orders for a given Customer.
 * 
 * @author Michael Vorburger
 */
@SuppressWarnings("serial")
public class CustomerOrders extends VerticalLayout {
	// TODO CssLayout?

	private final Label customerInfoLabel;
	private final Table<Order> ordersTable;
	
	public CustomerOrders() {
		super();
		
		customerInfoLabel = new Label();
		addComponent(customerInfoLabel);
		
		ordersTable = new Table<Order>() {
			@Override
			protected void configureAfterSetModel() {
				setVisibleColumns(new Object[] { "date" });
			}
		};
		addComponent(ordersTable);
	}
	
	public void setModel(Customer customer) {
		// TODO Support using an EL later
		customerInfoLabel.setCaption("Orders for Customer '" + customer.name + "'");
		
		Set<Order> orders = customer.getOrders();
		ordersTable.setModel(Order.class, orders);
		
		// configureAfterSetModel();
	}

}
