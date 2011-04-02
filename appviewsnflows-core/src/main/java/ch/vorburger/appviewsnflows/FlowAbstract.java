package ch.vorburger.appviewsnflows;


/**
 * Abstract base class with typical implementation of Flow interface.
 * 
 * @author Michael Vorburger
 */
public abstract class FlowAbstract implements Flow {
	
	// TODO This currently may have mixed up "descriptor" and "instance", does it need to be tear apart later?
	
	private View currentView;

	protected FlowAbstract() {
		currentView = noView;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends View> T getCurrentView() {
		return (T) currentView;
	}

	@Override
	public void onEvent(Event event) {
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
	public View handleEvent(Event event) {
		throw new FlowException("Event " + event.toString() + " occured while on view " + getCurrentView().toString() + " but wasn't handled; I don't know where do you want to go today?!");
	}
	
	
	/**
	 * View which the Flow is on before any Event was handled.
	 */
	protected static class NoView implements View {
		private NoView() {
		}
	}
	private static NoView noView = new NoView();
}
