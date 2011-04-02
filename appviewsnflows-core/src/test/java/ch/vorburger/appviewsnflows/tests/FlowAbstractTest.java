package ch.vorburger.appviewsnflows.tests;

import org.junit.Test;

import ch.vorburger.appviewsnflows.Event;
import ch.vorburger.appviewsnflows.FlowAbstract;
import ch.vorburger.appviewsnflows.FlowException;
import ch.vorburger.appviewsnflows.View;

/**
 * Unit Test for AppFlowAdapter.
 * 
 * @see FlowAbstract
 * @author Michael Vorburger
 */
public class FlowAbstractTest {

	@Test(expected=FlowException.class)
	public void testAppFlowAdapterEventNotHandled() {
		FlowAbstract flow = new FlowAbstract(new View() {
		}) {
		};

		flow.handleEvent(new Event<String>(null) {
		});
	}

}
