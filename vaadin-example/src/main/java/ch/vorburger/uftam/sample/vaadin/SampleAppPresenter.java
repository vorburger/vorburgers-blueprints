package ch.vorburger.uftam.sample.vaadin;

import ch.vorburger.appviewsnflows.dyn.Flow;
import ch.vorburger.appviewsnflows.vaadin.AbstractPresenter;
import ch.vorburger.uftam.sample.vaadin.views.CustomerOrdersView;
import ch.vorburger.uftam.sample.vaadin.views.CustomersListView;
import ch.vorburger.uftam.sample.vaadin.views.MainRootWindowView;

/**
 * MVP Presenter.
 *
 * @author Michael Vorburger
 */
public class SampleAppPresenter extends AbstractPresenter {

	MainRootWindowView mainView;

//	public void showOrders(Customer customer) {
//		CustomerOrdersView view = new CustomerOrdersView();
//		view.setPresenter(this);
//		view.setModel(customer);
//		mainView.setMainView(view);
//	}

//	p.mainView = mainDecoView;
//	mainDecoView.setPresenter(p);
//	firstView.setPresenter(p);


	@Override
	protected Flow configureFlow() {
		Flow flow = new Flow("main");
		// TODO start should be strongly typed!
		flow.onView(Flow.EmptyView.class).onEvent("start").goTo(CustomersListView.class);
		// TODO Support CustomersListView.ItemClickedEvent instead of "itemClicked" !
		flow.onView(CustomersListView.class).onEvent("itemClicked").goTo(CustomerOrdersView.class);
		return flow;
	}

}
