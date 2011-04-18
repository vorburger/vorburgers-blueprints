package ch.vorburger.uftam.sample.vaadin.justcomponents;

import ch.vorburger.uftam.sample.model.representation.UserInfo;

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
	// TODO CssLayout!

	private Component body;
	private Component userInfoBlock;
	
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
		top.setComponentAlignment(logo, Alignment.TOP_RIGHT);
		// ? lo.setExpandRatio(em, 1);

		top.setWidth("100%");
		addComponent(top);

		userInfoBlock = new Label();
		addComponent(userInfoBlock);
		
		body = firstBody; 
		body.setSizeFull();
		addComponent(body);
		
		Label footer = new Label("Vaadin Example Application created by <a href=\"http://www.vorburger.ch\">Michael Vorburger</a>", Label.CONTENT_XHTML);
		footer.setWidth(100, UNITS_PERCENTAGE);
		addComponent(footer);
		setComponentAlignment(footer, Alignment.BOTTOM_CENTER);
	}

	public void setBody(Component newBody) {
		newBody.setSizeFull();
		replaceComponent(body, newBody);
		body = newBody;
	}

	public void setUserInfo(UserInfo userInfo) {
		userInfoBlock.setCaption("User: " + userInfo.getUID());
	}

}
