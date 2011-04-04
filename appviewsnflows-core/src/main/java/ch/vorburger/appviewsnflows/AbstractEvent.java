package ch.vorburger.appviewsnflows;

/**
 * Abstract base class with typical implementation of Event interface.
 * 
 * @author Michael Vorburger
 */
public abstract class AbstractEvent implements Event {

	@Override
	public String getEventId() {
		return getClass().getName();
	}

}
