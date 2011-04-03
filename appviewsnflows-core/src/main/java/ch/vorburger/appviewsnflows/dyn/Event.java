package ch.vorburger.appviewsnflows.dyn;

/**
 * Event implementation which can be configured dynamically at run-time.
 * 
 * @author Michael Vorburger
 */
public class Event implements ch.vorburger.appviewsnflows.Event {

	private final String eventId;
	private final Object[] data;

	public Event(String eventId, Object... data) {
		this.eventId = eventId;
		this.data = data;
	}

	@Override
	public String getEventId() {
		return eventId;
	}

	@Override
	public Object[] getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return "DynEvent:" + eventId;
	}

}
