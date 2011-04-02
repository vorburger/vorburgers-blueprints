package ch.vorburger.appviewsnflows.tests.flows;

import java.util.List;

import ch.vorburger.appviewsnflows.Event;
import ch.vorburger.appviewsnflows.Flow;
import ch.vorburger.appviewsnflows.FlowAbstract;
import ch.vorburger.appviewsnflows.View;
import ch.vorburger.appviewsnflows.tests.dataobjects.Customer;
import ch.vorburger.appviewsnflows.tests.views.CustomerSummaryView;
import ch.vorburger.appviewsnflows.tests.views.CustomersListView;

/**
 * First and quite simple Test Flow.
 * 
 * @author Michael Vorburger
 */
public class SimplestTestFlow extends FlowAbstract implements Flow {

	public SimplestTestFlow(List<Customer> customers) {
		super(new CustomersListView(this, customers));
	}

	@Override
	public View handleEvent(Event event) {
		if (getCurrentView() instanceof CustomersListView) {
			if (event instanceof CustomersListView.CustomerClickedEvent) {
				CustomersListView.CustomerClickedEvent e = (CustomersListView.CustomerClickedEvent) event;
				return new CustomerSummaryView(this, e.getData());
			}
		}
		return super.handleEvent(event);
	}

}
