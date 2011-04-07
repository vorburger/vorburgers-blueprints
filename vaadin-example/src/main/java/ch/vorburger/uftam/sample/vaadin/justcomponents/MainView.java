package ch.vorburger.uftam.sample.vaadin.justcomponents;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Application Main Window View.
 * This is the "frame" shown around other views with e.g. menu and header/logo stuff.
 * 
 * @author Michael Vorburger
 */
@SuppressWarnings("serial")
public class MainView extends VerticalLayout {
	// TODO CssLayou!

	private Component body;
	
	public MainView(Component firstBody) {
		super();
		
		setMargin(true);
		setSizeFull();
		
		HorizontalLayout top = new HorizontalLayout();
		
		Label name = new Label("Sample App");
		top.addComponent(name);
		top.setComponentAlignment(name , Alignment.TOP_LEFT);		
		
		Component logo = new Label("ACME Inc.");
		top.addComponent(logo);
		top.setComponentAlignment(logo , Alignment.TOP_RIGHT);
		// ? lo.setExpandRatio(em, 1);

		top.setWidth("100%");
		addComponent(top);

		body = firstBody; 
		body.setSizeFull();
		addComponent(body);
		
		HorizontalLayout footer = new HorizontalLayout();
		footer.setCaption("Vaadin Example Application created by Michael Vorburger");
		addComponent(footer);
		setComponentAlignment(footer, Alignment.BOTTOM_CENTER);
	}

	public void setBody(Component newBody) {
		newBody.setSizeFull();
		replaceComponent(body, newBody);
		body = newBody;
	}

}
