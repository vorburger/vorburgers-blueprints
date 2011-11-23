package ch.vorburger.uftam.sample.vaadin;

import java.util.Iterator;

import com.vaadin.data.Property.ValueChangeNotifier;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;

/**
 * Utils for Vaadin.
 *
 * @author Michael Vorburger
 */
public abstract class VaadinUtil {
	private VaadinUtil() {
	}
	
	// TODO Review if to keep - my intended "Component container" (read from XML) should, eventually, make this unnecessary. 
	
	// TODO public static Component getComponent(ComponentContainer c, String privateFieldName);
	
	public static void attachListeners(ComponentContainer c) {
		Iterator<Component> components = c.getComponentIterator();
		while (components.hasNext()) {
			Component component = components.next();
			if (component instanceof Button) {
				Button buttonComponent = (Button) component;
				ClickListener clickListener = new ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						throw new UnsupportedOperationException(); // TODO
						
					}
				} ;
				buttonComponent.addListener(clickListener);
			
			} else if (component instanceof ValueChangeNotifier) {
				ValueChangeNotifier valueChangeNotifier = (ValueChangeNotifier) component;
				// TODO ...
			}
		}
	}
}
