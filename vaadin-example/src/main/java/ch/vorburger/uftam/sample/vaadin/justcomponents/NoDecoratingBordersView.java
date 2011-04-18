package ch.vorburger.uftam.sample.vaadin.justcomponents;

import ch.vorburger.blueprint.ui.vaadin.views.ViewContainer;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Panel;

public class NoDecoratingBordersView extends Panel implements ViewContainer<NoDecoratingBordersView> {

	public NoDecoratingBordersView(ComponentContainer firstBody) {
		super(firstBody);
	}

	@Override
	public <T extends ComponentContainer> void setView(ch.vorburger.blueprint.ui.vaadin.views.ViewContainer.ViewSlot<T, NoDecoratingBordersView> slot, T view) {
		setContent(view);
	}

}
