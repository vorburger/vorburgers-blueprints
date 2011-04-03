package ch.vorburger.uftam.sample.vaadin;

import java.util.Collection;
import java.util.Set;

import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.Order;
import ch.vorburger.uftam.sample.model.domain.repository.CustomersRepository;

import com.vaadin.Application;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;

public class UFTAMSampleApplication extends Application {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		final Window mainWindow = new Window("UFTAM Vaadin Sample Application");
//		Label label = new Label("Hello Vaadin user");
//		mainWindow.addComponent(label);
		
		Collection<? extends Customer> customers = CustomersRepository.getAFewCustomers();
		Container customersDataSource = new BeanItemContainer<Customer>(Customer.class, customers);
		Table customersTable = new Table("Customers", customersDataSource);
		customersTable.setSelectable(true);
		customersTable.setImmediate(true);
		customersTable.addListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				@SuppressWarnings("unchecked")
				BeanItem<Customer> item = (BeanItem<Customer>) event.getItem();
				Customer customer = item.getBean();
				Set<Order> orders = customer.getOrders();
				
				Container ordersDataSource = new BeanItemContainer<Order>(Order.class, orders);
				Table ordersTable = new Table("Orders for Customer " + customer.name, ordersDataSource);
				mainWindow.addComponent(ordersTable);
			}
		});
		mainWindow.addComponent(customersTable);
		
		setMainWindow(mainWindow);
	}

}
