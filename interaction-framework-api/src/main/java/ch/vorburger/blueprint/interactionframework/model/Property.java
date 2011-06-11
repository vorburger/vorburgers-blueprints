package ch.vorburger.blueprint.interactionframework.model;

// TODO Doc
public interface Property<T> {

	T getValue();
	void setValue(T newValue);
	
	boolean isAvailable();
}
