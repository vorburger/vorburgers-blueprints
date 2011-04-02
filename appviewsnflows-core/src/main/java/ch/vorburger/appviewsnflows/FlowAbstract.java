package ch.vorburger.appviewsnflows;


/**
 * Abstract base class with typical implementation of Flow interface.
 * 
 * @author Michael Vorburger
 */
public abstract class FlowAbstract implements Flow {
	
	// TODO This currently mixed up "descriptor" and "instance", tear apart later
	
	private View currentView;

	protected FlowAbstract(View initialView) {
		if (initialView == null) {
			throw new IllegalArgumentException("initialView == null");
		}
		currentView = initialView;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends View> T getCurrentView() {
		return (T) currentView;
	}

	@Override
	public <T> void onEvent(Event<T> event) {
		View nextView = handleEvent(event);
		if (nextView == null) {
			throw new FlowException("Event " + event.toString() + " occured while on view " + getCurrentView().toString() + " and was handled but returned null; I don't know where do you want to go today?!");
		}
		currentView = nextView; 
	}

	/**
	 * Handle an Event occurring on the current view.
	 * 
	 * @param event the Event
	 * @return next View
	 */
	public <T> View handleEvent(Event<T> event) {
		throw new FlowException("Event " + event.toString() + " occured while on view " + getCurrentView().toString() + " but wasn't handled; I don't know where do you want to go today?!");
	}
}
