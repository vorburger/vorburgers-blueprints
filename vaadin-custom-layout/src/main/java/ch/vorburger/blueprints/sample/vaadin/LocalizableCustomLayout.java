package ch.vorburger.blueprints.sample.vaadin;

import java.io.IOException;
import java.io.InputStream;

import com.vaadin.service.ApplicationContext;
import com.vaadin.terminal.gwt.server.PortletApplicationContext;
import com.vaadin.terminal.gwt.server.PortletApplicationContext2;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import com.vaadin.ui.CustomLayout;

/**
 * Localizable CustomLayout.
 *
 * @author Michael Vorburger
 */
public class LocalizableCustomLayout extends CustomLayout {

	// TODO Move out of sample application, into separate module
	
	public LocalizableCustomLayout(InputStream templateStream) throws IOException {
		throw new UnsupportedOperationException();
	}

//	public LocalizableCustomLayout(String templateName) {
//		this(inputStreamFromTemplate(templateName));
//	}
//
//	private static InputStream inputStreamFromTemplate(String templateName) {
//		final String path = templateName; // TODO uh... really?
//		// TODO Vaadin should have a getResourceAsStream() & getResource() on ApplicationContext.. file a ticket!
//		InputStream is;
//		ApplicationContext context = getApplication().getContext();
//		if (context instanceof WebApplicationContext) {
//			WebApplicationContext webApplicationContext = (WebApplicationContext) context;
//			is = webApplicationContext.getHttpSession().getServletContext().getResourceAsStream(path);
//		} else if (context instanceof PortletApplicationContext2) {
//			PortletApplicationContext2 portletApplicationContext2 = (PortletApplicationContext2) context;
//			// TODO Add Portlet API to pom.xml (as <provided>) and finish this: portletApplicationContext2.getPortletSession()
//			throw new UnsupportedOperationException("TODO Implement me... ;-)");
//		}
//		return is;
//	}

}
