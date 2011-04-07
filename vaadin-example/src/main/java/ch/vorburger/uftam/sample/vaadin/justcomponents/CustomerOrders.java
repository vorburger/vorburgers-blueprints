package ch.vorburger.uftam.sample.vaadin.justcomponents;

import java.util.Set;

import ch.vorburger.blueprint.ui.vaadin.Table;
import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.Order;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 * View showing a list of Orders for a given Customer.
 * 
 * @author Michael Vorburger
 */
@SuppressWarnings("serial")
public class CustomerOrders extends VerticalLayout {
	// TODO CssLayout?

	private final Label customerInfo;
	private final Table<Order> ordersTable;
	
	public CustomerOrders() {
		super();
		
		Button customersLink = new Button("Customers");
		customersLink.setStyleName(BaseTheme.BUTTON_LINK);
		customersLink.setDescription("Back to Customers List");
		// ?? customerInfoLink.addListener(this); // react to clicks
		addComponent(customersLink);
	        
		customerInfo = new Label();
		addComponent(customerInfo);
		
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
		customerInfo.setCaption("Orders for Customer: " + customer.name);
		Set<Order> orders = customer.getOrders();
		ordersTable.setModel(Order.class, orders);
		// configureAfterSetModel();
	}

}
