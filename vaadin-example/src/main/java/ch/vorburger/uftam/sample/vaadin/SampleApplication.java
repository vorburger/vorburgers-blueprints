package ch.vorburger.uftam.sample.vaadin;

import java.util.Collection;

import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.repository.CustomersRepository;
import ch.vorburger.uftam.sample.model.representation.UserInfo;
import ch.vorburger.uftam.sample.vaadin.justcomponents.CustomerList;
import ch.vorburger.uftam.sample.vaadin.justcomponents.CustomerOrders;
import ch.vorburger.uftam.sample.vaadin.justcomponents.MainView;
import ch.vorburger.uftam.sample.vaadin.justcomponents.MainViewWithCustomLayout;

import com.vaadin.Application;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window;

public class SampleApplication extends Application implements ItemClickListener, ClickListener {
	private static final long serialVersionUID = 1L;

	// TODO Later when the Flow creates the Views then this will be dynamic
	private MainView/* WithCustomLayout */mainView;
	private CustomerList customerList;

	private Button goToCustomers;

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

		UserInfo userInfo = new UserInfo() {
			@Override
			public String getUID() {
				return "michael.vorburger";
			}
		};

		// MainRootWindowView mainView = new MainRootWindowView(p);
		mainView = new MainView/* WithCustomLayout */(customerList);
		// mainView.setMainView(firstView);

		mainView.setModel(MainView.USER_INFO, userInfo); // = mainView.setUserInfo(userInfo);

		// mainView = customerList;

		// Component component = mainDecoView.getRootComponent();
		// ComponentContainer rootViewComponent = (ComponentContainer) component;
		// final Window mainWindow = new Window("UFTAM Vaadin Sample Application",
		// rootViewComponent);
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
			goToCustomers = customerOrders.goToCustomers();
			goToCustomers.addListener(this);
			customerOrders.setModel(customer);
			mainView.setBody(customerOrders);
		}

	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getComponent() == goToCustomers) {
			mainView.setBody(customerList);
		}

	}

}
