package ch.vorburger.blueprint.interactionframework.model;

import java.io.Serializable;

// TODO Doc
public interface Property<T> extends Serializable {

	T getValue();
	void setValue(T newValue);
	
	boolean isAvailable();
}
