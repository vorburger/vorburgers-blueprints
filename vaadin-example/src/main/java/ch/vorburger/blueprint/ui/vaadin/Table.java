package ch.vorburger.blueprint.ui.vaadin;

import java.util.Collection;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;

/**
 * TODO
 * 
 * @author Michael Vorburger
 */
@SuppressWarnings("serial")
public class Table<T> extends com.vaadin.ui.Table {

	public Table() {
		super();

		setColumnReorderingAllowed(true);
		setColumnCollapsingAllowed(true);

		// TODO always? ideally from the outside, if an onClick Event Handler is set on this
		// Table... hm.
		setSelectable(true);
		setImmediate(true);
	}

	// TODO @Override ?
	// TODO don't use Collection but some Paging thing...
	// TODO is there any way to write this better, and avoid the Class - somehow with TypeLiteral
	// may be?!
	public void setModel(Class<T> klass, Collection<T> data) {
		Container customersDataSource = new BeanItemContainer<T>(klass, data);
		setContainerDataSource(customersDataSource);

		configureAfterSetModel();
	}

	protected void configureAfterSetModel() {
	}
}
