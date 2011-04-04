package ch.vorburger.appviewsnflows.vaadin;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;

/**
 * TODO
 *
 * @param <T> Java Class Type of the Model of this View
 *
 * @author Michael Vorburger
 */
public interface View<T> {
	// TODO extend ch.vorburger.appviewsnflows.View ? Or contain instead of inherit?

	/**
	 * Implementations must not "construct" the component here; it should have been constructed
	 * before and simply returned here.
	 */
	Component getRootComponent();

	void setModel(T model);

	// TODO move this up into non-Vaddin View (or new ViewContainer extends View?)
	void setSubView(String slotName, View<?> subView);
}
