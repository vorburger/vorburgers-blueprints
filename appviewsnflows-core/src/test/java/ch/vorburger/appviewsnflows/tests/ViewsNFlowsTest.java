package ch.vorburger.appviewsnflows.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test.
 * 
 * @author Michael Vorburger
 */
public class ViewsNFlowsTest {

	@Test
	public void testViewsNFlows() {
		List<Customer> customers = new ArrayList<Customer>(1);
		firstCustomer = new Customer();
		customers.add(firstCustomer);
		
		flow = new SimplestFlow(customers);
		flow.start();
		View view = flow.getCurrentView();
		Assert.assertThat(view, instanceOf(CustomersListView.class));
		CustomersListView customersListView = (CustomersListView) view;
		Assert.assertThat(customersListView.getCustomers(), equalTo(customers));
		
		customersListView.sayUserClickedOnFirstCustomer();
		view = flow.getCurrentView();
		Assert.assertThat(view, instanceOf(CustomerSummaryView.class));
		CustomerSummaryView customerSummaryView = (CustomerSummaryView) view;
		Assert.assertThat(customerSummaryView.getCustomer(), equalTo(firstCustomer));
	}
}
