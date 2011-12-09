package ch.vorburger.blueprints.sample.vaadin;

import java.io.IOException;
import java.io.InputStream;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application
{
    private Window window;

    @Override
    public void init()
    {
        window = new Window("Wikipedia-Homepage");
        setMainWindow(window);
        
        setTheme("mycustotheme");
        CustomLayout htmlLayout = new CustomLayout("Wikipedia-Homepage");
//        InputStream is = getClass().getResourceAsStream("/Wikipedia-Homepage.html");
//        if (is == null) {
//        	throw new RuntimeException("Resource not found");
//        }
//		try {
//			htmlLayout = new CustomLayout(is);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
        final TextField textInput = new TextField();
        textInput.setValue("Michael");
        // textInput.setCaption("Bla bla bla");
        //textInput.setStyleName("none");
		htmlLayout.addComponent(textInput, "searchInputLocation");
        
		Button searchGo = new NativeButton(); // or just new Button() for <div> instead of <button>
		searchGo.setCaption("  →  ");
		searchGo.addListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				window.showNotification("Thanks! Searching " + textInput.getValue() + "...");
			}
		});
		htmlLayout.addComponent(searchGo, "searchGoButton");
		
		window.setContent(htmlLayout);
        
//        Button button = new Button("Click Me");
//        button.addListener(new Button.ClickListener() {
//            public void buttonClick(ClickEvent event) {
//                window.addComponent(new Label("Thank you for clicking"));
//            }
//        });
//        window.addComponent(button);
        
    }
    
}
