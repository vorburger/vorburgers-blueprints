package ch.vorburger.appviewsnflows;

/**
 * An Event with 1 strongly typed data parameter.
 * 
 * @author Michael Vorburger
 */
public abstract class Event1<T> implements Event {

	private final T data;

	protected Event1(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
}
