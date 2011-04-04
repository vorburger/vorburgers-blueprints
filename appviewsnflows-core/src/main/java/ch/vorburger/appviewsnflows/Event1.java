package ch.vorburger.appviewsnflows;

/**
 * An Event with 1 strongly typed data parameter.
 * 
 * @author Michael Vorburger
 */
public abstract class Event1<T> extends AbstractEvent implements Event {

	@SuppressWarnings("unchecked")
	private final T[] data = (T[]) new Object[1];

	protected Event1(T data) {
		this.data[0] = data;
	}

	public T getData1() {
		return data[0];
	}
	
	@Override
	public T[] getData() {
		return data;
	}
}
