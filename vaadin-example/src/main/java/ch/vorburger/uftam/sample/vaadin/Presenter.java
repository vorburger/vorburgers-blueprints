package ch.vorburger.uftam.sample.vaadin;

import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.vaadin.views.CustomerOrdersView;
import ch.vorburger.uftam.sample.vaadin.views.MainRootWindowView;

/**
 * MVP Presenter.
 *
 * @author Michael Vorburger
 */
public class Presenter {

	MainRootWindowView mainView;

	public void showOrders(Customer customer) {
		CustomerOrdersView view = new CustomerOrdersView();
		view.setPresenter(this);
		view.setModel(customer);
		mainView.setMainView(view);

	}

}
