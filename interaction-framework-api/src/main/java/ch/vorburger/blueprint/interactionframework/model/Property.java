package ch.vorburger.blueprint.interactionframework.model;

import java.io.Serializable;

import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface Property<T> extends Serializable {

	T getValue();
	void setValue(T newValue);
	
	boolean isAvailable();
	// TODO boolean isModifiable();
	// TODO List<T> getPermittedValues()
	
	// TODO PropertyType getPropertyType(); ?
	// No! Memory requirement... pointless to hold a type pointer in every value! Can solve better?
}
