package ch.vorburger.appviewsnflows;


/**
 * Abstract base class with typical implementation of View interface.
 * 
 * @author Michael Vorburger
 */
public abstract class AbstractView implements View {

	// TODO ? protected dataModels
	
	private final Flow ofFlow;

	protected AbstractView(Flow flow) {
		this.ofFlow = flow;
	}
	
	protected void send(Event event) {
		ofFlow.onEvent(event);
	}

}
