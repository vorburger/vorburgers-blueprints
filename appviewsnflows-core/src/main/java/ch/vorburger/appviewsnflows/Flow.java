package ch.vorburger.appviewsnflows;

/**
 * Flow through an Application.
 * 
 * @author Michael Vorburger
 */
public interface Flow {

	<T extends View> T getCurrentView();

	/**
	 * Handle an Event which occurred on the current view.
	 * 
	 * @param event the Event
	 */
	void onEvent(Event event);
	
}
