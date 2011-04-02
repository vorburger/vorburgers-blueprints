package ch.vorburger.appviewsnflows.tests;

import org.junit.Assert;
import org.junit.Test;

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
	public void testAppFlowAdapterStartStart() {
		FlowAbstract flow = new FlowAbstract() {
		};
		
		flow.start();
		// starting an already started Flow should fail
		flow.start();
		Assert.fail("Should have failed");
	}
}
