package ch.vorburger.appviewsnflows;


/**
 * Abstract base class with typical implementation of View interface.
 * 
 * @author Michael Vorburger
 */
public abstract class ViewAbstract implements View {

	// TODO ? protected dataModels
	
	private final Flow ofFlow;

	protected ViewAbstract(Flow flow) {
		this.ofFlow = flow;
	}
	
	protected void send(Event event) {
		ofFlow.onEvent(event);
	}

}
