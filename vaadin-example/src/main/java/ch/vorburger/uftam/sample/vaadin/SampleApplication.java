package ch.vorburger.uftam.sample.vaadin;

import java.util.Collection;

import ch.vorburger.appviewsnflows.vaadin.AbstractView;
import ch.vorburger.appviewsnflows.vaadin.Presenter;
import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.repository.CustomersRepository;
import ch.vorburger.uftam.sample.vaadin.views.CustomersListView;
import ch.vorburger.uftam.sample.vaadin.views.MainRootWindowView;

import com.vaadin.Application;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Window;

public class SampleApplication extends Application {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		Presenter p = new SampleAppPresenter();

		Collection<Customer> customers = CustomersRepository.getAFewCustomers();
		AbstractView<Collection<Customer>> firstView = new CustomersListView(p);
		firstView.setModel(customers);
		
		MainRootWindowView mainDecoView = new MainRootWindowView(p);
		mainDecoView.setMainView(firstView);
		
		Component component = mainDecoView.getRootComponent();
		ComponentContainer rootViewComponent = (ComponentContainer) component;
		final Window mainWindow = new Window("UFTAM Vaadin Sample Application", rootViewComponent);
		setMainWindow(mainWindow);
	}

}
