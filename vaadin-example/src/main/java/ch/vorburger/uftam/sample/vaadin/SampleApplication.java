package ch.vorburger.uftam.sample.vaadin;

import java.util.Collection;

import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.repository.CustomersRepository;
import ch.vorburger.uftam.sample.vaadin.justcomponents.CustomerList;
import ch.vorburger.uftam.sample.vaadin.justcomponents.CustomerOrders;
import ch.vorburger.uftam.sample.vaadin.justcomponents.MainViewWithCustomLayout;

import com.vaadin.Application;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Window;

public class SampleApplication extends Application implements ItemClickListener {
	private static final long serialVersionUID = 1L;

	// TODO Later when the Flow creates the Views then this will be dynamic
	private MainViewWithCustomLayout mainView;
	private CustomerList customerList;
	
	@Override
	public void init() {
		setTheme("mytheme");
		
		// Presenter p = new SampleAppPresenter();

		// TODO Later this won't be here be in the SampleAppPresenter Flow, only
		Collection<Customer> customers = CustomersRepository.getAFewCustomers();
		
		// AbstractView<Collection<Customer>> firstView = new CustomersListView(p);
		customerList = new CustomerList();
		customerList.setModel(Customer.class, customers);
		
		customerList.addListener(this);
		
		// MainRootWindowView mainView = new MainRootWindowView(p);
		mainView = new MainViewWithCustomLayout(customerList);
		// mainView.setMainView(firstView);
		
		// Component component = mainDecoView.getRootComponent();
		// ComponentContainer rootViewComponent = (ComponentContainer) component;
		// final Window mainWindow = new Window("UFTAM Vaadin Sample Application", rootViewComponent);
		final Window mainWindow = new Window("UFTAM Vaadin Sample Application", mainView);
		
		setMainWindow(mainWindow);
	}


	@Override
	public void itemClick(ItemClickEvent event) {
		// TODO Later when the Flow creates the Views then this will be dynamic
		if (event.getComponent() == customerList) {
			@SuppressWarnings("unchecked")
			BeanItem<Customer> item = (BeanItem<Customer>) event.getItem();
			Customer customer = item.getBean();

			CustomerOrders customerOrders = new CustomerOrders();
			customerOrders.setModel(customer);
			mainView.setBody(customerOrders);
		}
		
	}

}
