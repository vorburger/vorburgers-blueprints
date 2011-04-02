package ch.vorburger.appviewsnflows;

/**
 * Event - something that "happens" in a View.
 * 
 * This intentionally does not sub-class the java.util.EventObject, because that
 * is not type safe (generics), and because it's terminology ("sender") is less
 * suitable for this purpose.
 * 
 * There is no "Listener" for these simple Events, it's not a classical Observer
 * pattern, as the only purpose is to transpart data, from type-safe subclasses
 * of this abstract Event, from within View through to Flow logic.
 * 
 * @author Michael Vorburger
 */
public abstract class Event<T> {
	// TODO Should be inner class of View?

	private final T data;

	protected Event(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

}
