package ch.vorburger.blueprint.ui.vaadin.views;

import ch.vorburger.blueprint.common.Thing;

/**
 * TODO Doc! ;-)
 * 
 * @author Michael Vorburger
 */
public interface View<ViewT> {

	interface ModelSlot<T, ViewT> extends Thing<T> {
	}

	<T> void setModel(ModelSlot<T, ViewT> slot, T model);
}
