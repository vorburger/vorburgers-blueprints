package ch.vorburger.appviewsnflows.tests;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ch.vorburger.appviewsnflows.AppFlow;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;
import ch.vorburger.appviewsnflows.tests.flows.SimplestFlow;
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
		
		AppFlow flow = new SimplestFlow(customers);
		flow.start();
		
		CustomersListView customersListView = flow.getCurrentView();
		Assert.assertThat(customersListView.getCustomers(), equalTo(customers));
		
		customersListView.sayUserClickedOnFirstCustomer();
		CustomerSummaryView customerSummaryView = flow.getCurrentView();
		Assert.assertThat(customerSummaryView.getCustomer(), equalTo(firstCustomer));

	}
}
