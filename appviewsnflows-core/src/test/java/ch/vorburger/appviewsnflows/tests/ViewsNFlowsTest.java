package ch.vorburger.appviewsnflows.tests;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ch.vorburger.appviewsnflows.Flow;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;
import ch.vorburger.appviewsnflows.tests.flows.SimplestTestFlow;
import ch.vorburger.appviewsnflows.tests.views.CustomerSummaryView;
import ch.vorburger.appviewsnflows.tests.views.CustomersListView;

/**
 * Test.
 * 
 * @author Michael Vorburger
 */
public class ViewsNFlowsTest {

	@Test
	public void testViewsNFlows() {
		List<Customer> customers = new ArrayList<Customer>(1);
		Customer firstCustomer = new Customer();
		customers.add(firstCustomer);
		
		// TODO Think through if passing in via constructor is right here - shouldn't the Flow be responsible for obtaining the customers model?!
		
		Flow flow = new SimplestTestFlow();
		flow.onEvent(new SimplestTestFlow.StartEvent(customers));
		
		CustomersListView customersListView = flow.getCurrentView();
		Assert.assertThat(customersListView.getCustomers(), equalTo(customers));
		
		customersListView.sayUserClickedOnFirstCustomer();
		CustomerSummaryView customerSummaryView = flow.getCurrentView();
		Assert.assertThat(customerSummaryView.getCustomer(), equalTo(firstCustomer));

	}
}
