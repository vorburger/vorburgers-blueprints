package ch.vorburger.uftam.sample.vaadin.justcomponents;

import ch.vorburger.blueprint.ui.vaadin.views.View;
import ch.vorburger.blueprint.ui.vaadin.views.ViewContainer;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;

/**
 * Uses CustomLayout.
 * 
 * @author Michael Vorburger
 */
public class MainViewWithCustomLayout extends CustomLayout implements View<MainView>, ViewContainer<MainView> {

	public MainViewWithCustomLayout(Component firstBody) {
		super("rootLayout");

		setBody(firstBody);
	}

	public void setBody(Component newBody) {
		newBody.setSizeFull();
		addComponent(newBody, "body");
	}

	@Override
	public <T> void setView(ch.vorburger.blueprint.ui.vaadin.views.ViewContainer.ViewSlot<T, MainView> slot, T view) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void setModel(ch.vorburger.blueprint.ui.vaadin.views.View.ModelSlot<T, MainView> slot, T model) {
		// TODO Auto-generated method stub

	}

}
