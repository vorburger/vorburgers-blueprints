package ch.vorburger.appviewsnflows.vaadin;

import java.util.Collection;

import ch.vorburger.appviewsnflows.Event1;

/**
 * List View.
 *
 * @param <T> Java Class Type of the Model of this View
 *
 * @author Michael Vorburger
 */
public abstract class AbstractListView<T> extends AbstractView<Collection<T>> {
	// TODO Shouldn't be Collection<T> but some Pageable thingie

	public AbstractListView(Presenter presenter) {
		super(presenter);
	}

	public class ItemClickedEvent extends Event1<T> {
		public ItemClickedEvent(T item) {
			super(item);
		}

		@Override
		public String getEventId() {
			return "itemClicked";
		}
	}

}
