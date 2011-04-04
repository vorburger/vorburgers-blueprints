package ch.vorburger.appviewsnflows.tests.dyn;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ch.vorburger.appviewsnflows.FlowException;
import ch.vorburger.appviewsnflows.dyn.Event;
import ch.vorburger.appviewsnflows.dyn.Flow;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;
import ch.vorburger.appviewsnflows.tests.views.CustomerSummaryView;
import ch.vorburger.appviewsnflows.tests.views.CustomersListView;

/**
 * Tests using the dyn approach, not the strongly-typed pure Java approach.
 * 
 * @author Michael Vorburger
 */
public class ViewsNFlowsDynTest {

	@Test
	public void testViewsNFlows() {
		List<Customer> customers = new ArrayList<Customer>(1);
		Customer firstCustomer = new Customer();
		customers.add(firstCustomer);

		Flow flow = new Flow("SimplestTest");
		flow.onView(Flow.EmptyView.class).onEvent("start").goTo(CustomersListView.class);
		flow.onView(CustomersListView.class).onEvent("customerClicked").goTo(CustomerSummaryView.class);

		flow.onEvent(new Event("start", customers));

		CustomersListView customersListView = flow.getCurrentView();
		Assert.assertThat(customersListView.getCustomers(), equalTo(customers));

		customersListView.sayUserClickedOnFirstCustomerViaDynEvent();
		CustomerSummaryView customerSummaryView = flow.getCurrentView();
		Assert.assertThat(customerSummaryView.getCustomer(), equalTo(firstCustomer));

		try {
			flow.onEvent(new Event("start" /* NO customers */));
			Assert.fail("Should have failed");
		} catch (FlowException e) {
			// Expected
		}
	}
}
