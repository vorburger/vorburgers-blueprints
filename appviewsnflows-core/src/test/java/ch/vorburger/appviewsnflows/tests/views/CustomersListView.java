package ch.vorburger.appviewsnflows.tests.views;

import java.util.List;

import ch.vorburger.appviewsnflows.Event;
import ch.vorburger.appviewsnflows.ViewAbstract;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;

/**
 * Test View.
 * 
 * @author Michael Vorburger
 */
public class CustomersListView extends ViewAbstract {

	private List<Customer> customers;
	// TODO static public ? customers = ? 
	
	public CustomersListView(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	
	public static class CustomerClickedEvent extends Event<Customer> {
		public CustomerClickedEvent(Customer customer) {
			super(customer);
		}
	}
	
	public void sayUserClickedOnFirstCustomer() {
		send(new CustomerClickedEvent(customers.get(0)));
	}

}