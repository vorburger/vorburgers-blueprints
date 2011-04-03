package ch.vorburger.appviewsnflows.tests.views;

import java.util.List;

import ch.vorburger.appviewsnflows.Event1;
import ch.vorburger.appviewsnflows.Flow;
import ch.vorburger.appviewsnflows.ViewAbstract;
import ch.vorburger.appviewsnflows.dyn.Event;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;

/**
 * Test View.
 * 
 * @author Michael Vorburger
 */
public class CustomersListView extends ViewAbstract {

	private final List<Customer> customers;
	// TODO static public ? CUSTOMERS = ? 
	
	public CustomersListView(Flow flow, List<Customer> customers) {
		super(flow);
		this.customers = customers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	
	public static class CustomerClickedEvent extends Event1<Customer> {
		public CustomerClickedEvent(Customer customer) {
			super(customer);
		}
	}
	
	public void sayUserClickedOnFirstCustomerViaJavaTypedEvent() {
		send(new CustomerClickedEvent(customers.get(0)));
	}
	
	
	public void sayUserClickedOnFirstCustomerViaDynEvent() {
		send(new Event("customerClicked", customers.get(0)));
	}
}
