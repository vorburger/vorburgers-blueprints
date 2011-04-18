package ch.vorburger.blueprint.ui.vaadin.views;

import com.vaadin.ui.ComponentContainer;

import ch.vorburger.blueprint.common.Thing;

/**
 * TODO Doc! ;-)
 * 
 * @author Michael Vorburger
 */
public interface ViewContainer<ViewT> {

	interface ViewSlot<T extends ComponentContainer, ViewT> extends Thing<T> {
	}

	<T extends ComponentContainer> void setView(ViewSlot<T, ViewT> slot, T view);

}
