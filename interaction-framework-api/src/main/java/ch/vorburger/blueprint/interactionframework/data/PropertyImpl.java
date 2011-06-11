package ch.vorburger.blueprint.interactionframework.data;

public class PropertyImpl<T> implements Property<T> {

	private T value;
	private boolean isAvailable = true;

	public PropertyImpl(T value) {
		super();
		this.value = value;
	}

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void setValue(T newValue) {
		this.value = newValue;
	}

	@Override
	public boolean isAvailable() {
		return isAvailable ;
	}

}