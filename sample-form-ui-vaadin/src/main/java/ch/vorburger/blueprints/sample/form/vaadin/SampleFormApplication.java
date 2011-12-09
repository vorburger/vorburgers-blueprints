package ch.vorburger.blueprints.sample.form.vaadin;

import com.vaadin.Application;
import com.vaadin.ui.Window;

public class SampleFormApplication extends Application {

	@Override
	public void init() {
		SampleFormView formView = new SampleFormView();
		final Window mainWindow = new Window("Vaadin Form Sample Application", formView);
		// INSTEAD of mainWindow.addComponent(formView);
		setMainWindow(mainWindow);
	}

}
