package ch.vorburger.uftam.sample.vaadin.justcomponents;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;

/**
 * Uses CustomLayout.
 * 
 * @author Michael Vorburger
 */
public class MainViewWithCustomLayout extends CustomLayout {

	public MainViewWithCustomLayout(Component firstBody) {
		super("rootLayout");
		
		setBody(firstBody);
	}

	public void setBody(Component newBody) {
		newBody.setSizeFull();
		addComponent(newBody, "body");
	}

}
