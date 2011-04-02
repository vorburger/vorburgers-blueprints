package ch.vorburger.appviewsnflows.tests.views;

import java.util.List;

import ch.vorburger.appviewsnflows.ViewAbstract;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;

/**
 * Test View.
 * 
 * @author Michael Vorburger
 */
public class CustomersListView extends ViewAbstract {

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void sayUserClickedOnFirstCustomer() {
		// TODO send(new Event(customers.get(1));
	}

}
