package ch.vorburger.appviewsnflows.vaadin;

import ch.vorburger.uftam.sample.vaadin.Presenter;

import com.vaadin.ui.Component;

/**
 * Abstract base class with typical implementation of Event interface.
 *
 * @author Michael Vorburger
 */
public abstract class AbstractView<T> implements View<T> {

	private /* final */ Presenter presenter;

	private final Component root;

	abstract protected Component createRootComponent();

	public AbstractView() {
		super();
		root = createRootComponent();
	}

	@Override
	public final Component getRootComponent() {
		return root;
	}

	@Override
	public void setModel(T model) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSubView(String slotName, View<?> subView) {
		throw new UnsupportedOperationException(slotName);
	}

	protected Presenter getPresenter() {
		if (presenter == null) {
			throw new IllegalStateException("Presenter not set on View");
		}
		return presenter;
	}

	public void setPresenter(Presenter presenter) {
		if (this.presenter == null) {
			this.presenter = presenter;
		} else {
			throw new IllegalStateException("Presenter already set");
		}
	}

}
