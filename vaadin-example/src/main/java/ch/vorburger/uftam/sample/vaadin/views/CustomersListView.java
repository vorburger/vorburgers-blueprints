package ch.vorburger.uftam.sample.vaadin.views;

import java.util.Collection;

import ch.vorburger.appviewsnflows.vaadin.AbstractListView;
import ch.vorburger.appviewsnflows.vaadin.Presenter;
import ch.vorburger.uftam.sample.model.domain.Customer;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

/**
 * View showing a list of Customers.
 *
 * @author Michael Vorburger
 */
public class CustomersListView extends AbstractListView<Customer> {

	private Table customersTable;

	public CustomersListView(Presenter presenter) {
		super(presenter);
	}

	@Override
	public Component createRootComponent() {
		customersTable = new Table("Customers");
		customersTable.setSelectable(true);
		customersTable.setImmediate(true);
		// TODO Later don't use visibleColumns prop. but (sub)representation
		customersTable.setColumnReorderingAllowed(true);
		customersTable.setColumnCollapsingAllowed(true);

		// TODO Later this shouldn't be here, but defined in the Flow
		customersTable.addListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				@SuppressWarnings("unchecked")
				BeanItem<Customer> item = (BeanItem<Customer>) event.getItem();
				Customer customer = item.getBean();

				send(new ItemClickedEvent(customer));
			}
		});

		return customersTable;
	}

	@Override
	// TODO don't use Collection but some Paging thing...
	public void setModel(Collection<Customer> customers) {
		Container customersDataSource = new BeanItemContainer<Customer>(Customer.class, customers);
		customersTable.setContainerDataSource(customersDataSource);

		customersTable.setVisibleColumns(new Object[] { "id", "name" });
	}
}
