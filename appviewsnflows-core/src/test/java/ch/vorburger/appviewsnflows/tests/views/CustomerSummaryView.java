package ch.vorburger.appviewsnflows.tests.views;

import ch.vorburger.appviewsnflows.Flow;
import ch.vorburger.appviewsnflows.ViewAbstract;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;

/**
 * Test View.
 * 
 * @author Michael Vorburger
 */
public class CustomerSummaryView extends ViewAbstract {

	private final Customer customer;
	// TODO static public ? CUSTOMER = ? 
	
	public CustomerSummaryView(Flow flow, Customer customer) {
		super(flow);
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}

}
