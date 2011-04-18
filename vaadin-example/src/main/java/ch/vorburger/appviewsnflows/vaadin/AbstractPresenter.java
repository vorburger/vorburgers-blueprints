package ch.vorburger.appviewsnflows.vaadin;

import ch.vorburger.appviewsnflows.Flow;

/**
 * MVP Presenter.
 * 
 * @author Michael Vorburger
 */
public abstract class AbstractPresenter implements Presenter {

	private final Flow flow;

	abstract protected Flow configureFlow();

	protected AbstractPresenter() {
		super();
		this.flow = configureFlow();
	}

	@Override
	public Flow getFlow() {
		return flow;
	}

}
