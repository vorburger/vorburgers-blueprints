package ch.vorburger.appviewsnflows.tests.java;

import java.util.List;

import ch.vorburger.appviewsnflows.Event;
import ch.vorburger.appviewsnflows.Event1;
import ch.vorburger.appviewsnflows.Flow;
import ch.vorburger.appviewsnflows.AbstractFlow;
import ch.vorburger.appviewsnflows.View;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;
import ch.vorburger.appviewsnflows.tests.views.CustomerSummaryView;
import ch.vorburger.appviewsnflows.tests.views.CustomersListView;

/**
 * First and quite simple Test Flow.
 * 
 * @author Michael Vorburger
 */
public class SimplestTestFlow extends AbstractFlow implements Flow {

	@Override
	protected View handleEvent(Event event) {
		if (getCurrentView() instanceof EmptyView) {
			if (event instanceof StartEvent) {
				StartEvent e = (StartEvent) event;
				return new CustomersListView(this, e.getData1());
			}
		} else if (getCurrentView() instanceof CustomersListView) {
			if (event instanceof CustomersListView.CustomerClickedEvent) {
				CustomersListView.CustomerClickedEvent e = (CustomersListView.CustomerClickedEvent) event;
				return new CustomerSummaryView(this, e.getData1());
			}
		}
		return super.handleEvent(event);
	}

	static public class StartEvent extends Event1<List<Customer>> {
		public StartEvent(List<Customer> customers) {
			super(customers);
		}
	}

}
