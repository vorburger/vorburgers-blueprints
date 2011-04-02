package ch.vorburger.appviewsnflows;

/**
 * Event - something that "happens" in a View.
 * 
 * The key for what happened is determined by specific type-safe subclasses of
 * this Event.
 * 
 * Events typically carry data that provide arbitrary payload parameters
 * detailing the event (e.g. what was clicked on). For the most typical case of
 * Event with exactly one parameter, see the Event1 class.
 * 
 * The full View object in which the event occurred is not part of the Event, as
 * the Flow when handling the Event already has this, and it should normally not
 * be used / needed to determining where to go anyways.
 * 
 * This intentionally does not sub-class the java.util.EventObject, because that
 * is not type safe (generics), and because it's terminology ("sender") is less
 * suitable for this purpose.
 * 
 * There is no "Listener" for these simple Events, it's not a classical Observer
 * pattern, as its only purpose is to transport data from within View through to
 * Flow logic.
 * 
 * @see Flow#onEvent(Event)
 * @author Michael Vorburger
 */
public interface Event {

}
