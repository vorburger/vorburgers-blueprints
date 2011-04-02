package ch.vorburger.appviewsnflows;


/**
 * Abstract base class with typical implementation of Flow interface.
 * 
 * @author Michael Vorburger
 */
public abstract class FlowAbstract implements Flow {
	
	// TODO This currently mixed up "descriptor" and "instance", tear apart later
	
	private View initialView;
	private View currentView;

	@Override
	public void start() {
		currentView = initialView;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends View> T getCurrentView() {
		return (T) currentView;
	}

	protected void setInitialView(View initialView) {
		this.initialView = initialView;
	}
}
