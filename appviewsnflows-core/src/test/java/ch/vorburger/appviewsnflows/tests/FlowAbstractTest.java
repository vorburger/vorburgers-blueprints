package ch.vorburger.appviewsnflows.tests;

import org.junit.Test;

import ch.vorburger.appviewsnflows.Event1;
import ch.vorburger.appviewsnflows.AbstractFlow;
import ch.vorburger.appviewsnflows.FlowException;

/**
 * Unit Test for AppFlowAdapter.
 * 
 * @see AbstractFlow
 * @author Michael Vorburger
 */
public class FlowAbstractTest {

	@Test(expected=FlowException.class)
	public void testAppFlowAdapterEventNotHandled() {
		AbstractFlow flow = new AbstractFlow() {
		};

		flow.onEvent(new Event1<String>(null) {
		});
	}

}
