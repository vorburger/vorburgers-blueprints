package ch.vorburger.appviewsnflows.tests.java;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ch.vorburger.appviewsnflows.Event;
import ch.vorburger.appviewsnflows.Flow;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;
import ch.vorburger.appviewsnflows.tests.views.CustomerSummaryView;
import ch.vorburger.appviewsnflows.tests.views.CustomersListView;

/**
 * Tests using only the strongly-typed pure Java approach (no dyn).
 * 
 * @author Michael Vorburger
 */
public class ViewsNFlowsJavaTypedTest {

	@Test
	public void testViewsNFlows() {
		List<Customer> customers = new ArrayList<Customer>(1);
		Customer firstCustomer = new Customer();
		customers.add(firstCustomer);
		
		Flow flow = new SimplestTestFlow();
		flow.onEvent(new SimplestTestFlow.StartEvent(customers));
		
		CustomersListView customersListView = flow.getCurrentView();
		Assert.assertThat(customersListView.getCustomers(), equalTo(customers));
		
		customersListView.sayUserClickedOnFirstCustomerViaJavaTypedEvent();
		CustomerSummaryView customerSummaryView = flow.getCurrentView();
		Assert.assertThat(customerSummaryView.getCustomer(), equalTo(firstCustomer));
	}
	
	@Test
	public void testEventTypeId() {
		Event e = new CustomersListView.CustomerClickedEvent(new Customer());
		Assert.assertThat(e.getEventId(), equalTo(CustomersListView.CustomerClickedEvent.class.getName()));
	}
}
