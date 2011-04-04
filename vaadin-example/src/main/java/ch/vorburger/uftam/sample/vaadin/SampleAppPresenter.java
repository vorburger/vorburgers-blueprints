package ch.vorburger.uftam.sample.vaadin;

import java.util.Collection;

import ch.vorburger.appviewsnflows.dyn.Event;
import ch.vorburger.appviewsnflows.dyn.Flow;
import ch.vorburger.appviewsnflows.vaadin.AbstractPresenter;
import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.repository.CustomersRepository;
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
		
		// TODO Following shouldn't here, but in an "Action" (remember to distinguish two types of Actions)
		Collection<Customer> customers = CustomersRepository.getAFewCustomers();
		// TODO How should the Flow get started, who should kick off 'start' (which shouldn't be String but a Class) ?
		flow.onEvent(new Event("start", customers));
		
		return flow;
	}

}
