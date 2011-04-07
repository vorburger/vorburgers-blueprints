package ch.vorburger.appviewsnflows;

/**
 * Event - something that "happens" in a View.
 * 
 * <p>The key for what happened is determined by specific type-safe subclasses of
 * this Event (unless the {@link ch.vorburger.appviewsnflows.dyn.Event} child
 * interface is used).</p>
 * 
 * <p>Events typically carry data that provide arbitrary payload parameters
 * detailing the event (e.g. what was clicked on). For the most typical case of
 * Event with exactly one parameter, see the {@link Event1} class.</p>
 * 
 * <p>The full View object in which the event occurred is not part of the Event, as
 * the Flow when handling the Event already has this, and it should normally not
 * be used / needed to determining where to go anyways.</p>
 * 
 * <p>This intentionally does not sub-class the java.util.EventObject, because that
 * is not type safe (generics), and because it's terminology ("sender") is less
 * suitable for this purpose.</p>
 * 
 * <p>There is no "Listener" for these simple Events, it's not a classical Observer
 * pattern, as its only purpose is to transport data from within View through to
 * Flow logic.</p>
 * 
 * @see Flow#onEvent(Event)
 * @author Michael Vorburger
 */
public interface Event {

	String getEventId();

	Object[] getData();
}
