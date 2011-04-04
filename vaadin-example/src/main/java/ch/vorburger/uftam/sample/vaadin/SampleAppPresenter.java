package ch.vorburger.uftam.sample.vaadin;

import ch.vorburger.appviewsnflows.dyn.Flow;
import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.vaadin.views.CustomerOrdersView;
import ch.vorburger.uftam.sample.vaadin.views.MainRootWindowView;

/**
 * MVP Presenter.
 *
 * @author Michael Vorburger
 */
public class SampleAppPresenter {

	MainRootWindowView mainView;

	public void showOrders(Customer customer) {
		CustomerOrdersView view = new CustomerOrdersView();
		view.setPresenter(this);
		view.setModel(customer);
		mainView.setMainView(view);

	}

	public void init() {
		Flow flow = new Flow("main");
		// flow.onView(CustomersListView.class).onEvent(")
	}

}
