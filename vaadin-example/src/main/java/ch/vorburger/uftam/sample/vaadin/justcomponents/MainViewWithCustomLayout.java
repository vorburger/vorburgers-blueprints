package ch.vorburger.uftam.sample.vaadin.justcomponents;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;

/**
 * Uses CustomLayout.
 * 
 * @author Michael Vorburger
 */
public class MainViewWithCustomLayout extends CustomLayout {

	private Component body;
	
	public MainViewWithCustomLayout(Component firstBody) {
		super("rootLayout");
		
		body = firstBody; 
		body.setSizeFull();
		addComponent(body, "body");
	}

	public void setBody(Component newBody) {
		newBody.setSizeFull();
		replaceComponent(body, newBody);
		body = newBody;
	}

}
