package ch.vorburger.appviewsnflows.tests;

import org.junit.Test;

import ch.vorburger.appviewsnflows.Event1;
import ch.vorburger.appviewsnflows.FlowAbstract;
import ch.vorburger.appviewsnflows.FlowException;

/**
 * Unit Test for AppFlowAdapter.
 * 
 * @see FlowAbstract
 * @author Michael Vorburger
 */
public class FlowAbstractTest {

	@Test(expected=FlowException.class)
	public void testAppFlowAdapterEventNotHandled() {
		FlowAbstract flow = new FlowAbstract() {
		};

		flow.handleEvent(new Event1<String>(null) {
		});
	}

}
