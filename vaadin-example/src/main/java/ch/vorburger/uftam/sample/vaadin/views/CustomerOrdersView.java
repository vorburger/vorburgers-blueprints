package ch.vorburger.uftam.sample.vaadin.views;

import java.util.Set;

import ch.vorburger.appviewsnflows.vaadin.AbstractView;
import ch.vorburger.appviewsnflows.vaadin.Presenter;
import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.Order;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

/**
 * View showing a list of Orders for a given Customer.
 *
 * @author Michael Vorburger
 */
public class CustomerOrdersView extends AbstractView<Customer> {

	private Table ordersTable;

	public CustomerOrdersView(Presenter presenter) {
		super(presenter);
	}

	@Override
	public Component createRootComponent() {
		ordersTable = new Table();
		return ordersTable;
	}

	@Override
	public void setModel(Customer customer) {
		ordersTable.setCaption("Orders for Customer '" + customer.name + "'");

		Set<Order> orders = customer.getOrders();
		Container ordersDataSource = new BeanItemContainer<Order>(Order.class, orders);
		// TODO Later don't use visibleColumns prop. but (sub)representation
		ordersTable.setContainerDataSource(ordersDataSource);
		ordersTable.setVisibleColumns(new Object[] { "date" });
	}

}
