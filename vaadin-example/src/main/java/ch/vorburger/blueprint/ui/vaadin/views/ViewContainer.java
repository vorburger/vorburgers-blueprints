package ch.vorburger.blueprint.ui.vaadin.views;

import ch.vorburger.blueprint.common.Thing;

/**
 * TODO Doc! ;-)
 * 
 * @author Michael Vorburger
 */
public interface ViewContainer<ViewT> extends View<ViewT> {

	interface ViewSlot<T, ViewT> extends Thing<T> {
	}

	<T> void setView(ViewSlot<T, ViewT> slot, T view);

}
