package ch.vorburger.uftam.sample.vaadin.views;

import ch.vorburger.appviewsnflows.vaadin.AbstractView;
import ch.vorburger.appviewsnflows.vaadin.Presenter;
import ch.vorburger.appviewsnflows.vaadin.View;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.VerticalLayout;

/**
 * Application Main Window View.
 * This is the "frame" shown around other views with e.g. menu and header/logo stuff.
 *
 * @author Michael Vorburger
 */
public class MainRootWindowView extends AbstractView<Void> {

	// TODO ACME Corp. header & logo!

	private VerticalLayout rootLayout;
	private Component currentMainComponent;

	public MainRootWindowView(Presenter presenter) {
		super(presenter);
	}

	@Override
	protected ComponentContainer createRootComponent() {
		rootLayout = new VerticalLayout();
		rootLayout.setMargin(true);
		return rootLayout;
	}

	public void setMainView(View<?> mainView) {
		setSubView("main", mainView);
	}

	@Override
	public void setSubView(String slotName, View<?> subView) {
		if ("main".equals(slotName)) {
			if (currentMainComponent != null) {
				rootLayout.replaceComponent(currentMainComponent, subView.getRootComponent());
			} else {
				rootLayout.addComponent(subView.getRootComponent());
			}
	        currentMainComponent = subView.getRootComponent();
		} else {
			throw new IllegalArgumentException("No such subview slot on this view: " + slotName);
		}
	}
}
