package ch.vorburger.appviewsnflows.tests.flows;

import java.util.List;

import ch.vorburger.appviewsnflows.Flow;
import ch.vorburger.appviewsnflows.FlowAbstract;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;
import ch.vorburger.appviewsnflows.tests.views.CustomersListView;

/**
 * First and quite simple Test Flow.
 * 
 * @author Michael Vorburger
 */
public class SimplestTestFlow extends FlowAbstract implements Flow {

	public SimplestTestFlow(List<Customer> customers) {
		setInitialView(new CustomersListView(customers));
	}

}
