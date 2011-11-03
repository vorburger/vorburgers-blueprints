package ch.vorburger.uftam.sample.vaadin;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.xmlxsd.XSDDataObjectFactory;
import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.repository.CustomersRepository;
import ch.vorburger.uftam.sample.model.representation.UserInfo;
import ch.vorburger.uftam.sample.vaadin.justcomponents.CustomerList;
import ch.vorburger.uftam.sample.vaadin.justcomponents.CustomerOrders;
import ch.vorburger.uftam.sample.vaadin.justcomponents.MainView;
import ch.vorburger.uftam.sample.vaadin.smartform.SampleFormView;

import com.vaadin.Application;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

public class SampleApplication extends Application implements ItemClickListener, ClickListener {
	private static final long serialVersionUID = 1L;

	// TODO Later when the Flow creates the Views then this will be dynamic
	private/* NoDecoratingBordersView*/ MainView /* WithCustomLayout */mainView;
	private CustomerList customerList;

	private Button goToCustomers;

	private Button goToFormDemo = new Button("Form Demo");
	
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

		mainView = new MainView/* WithCustomLayout */(customerList);
		mainView.setModel(MainView.USER_INFO, userInfo); // = mainView.setUserInfo(userInfo);

		// mainView = new NoDecoratingBordersView(customerList);

		// Component component = mainDecoView.getRootComponent();
		// ComponentContainer rootViewComponent = (ComponentContainer) component;
		// final Window mainWindow = new Window("UFTAM Vaadin Sample Application",
		// rootViewComponent);
		final Window mainWindow = new Window("UFTAM Vaadin Sample Application", mainView);

		// HACK!!!
		mainWindow.addComponent(goToFormDemo);
		goToFormDemo.addListener(this);
		
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
		
		if (event.getComponent() == goToFormDemo) {
			// HACK this shouldn't be in here later of course...
			XSDDataObjectFactory f = new XSDDataObjectFactory();
			try {
				f.register("/SampleFormStructure.xsd");
			} catch (IOException e) {
				// HACK Urgh - just shut up, for now..
				e.printStackTrace();
			}
			// 1. Create Form Data Model 
			DataObject dataObject = f.create("http://schemas.vorburger.ch/formsample#SampleFormType");
			dataObject.set("name", "Saluton, Mondpacxo");

			// 2. Create View (UI Model) 
			SampleFormView form = new SampleFormView();
			
			// 3. Bind Model to View (UI Model)
			form.getTextField_1().setValue(dataObject.get("name"));			
			
			mainView.setBody(form);
		}
	}

}
