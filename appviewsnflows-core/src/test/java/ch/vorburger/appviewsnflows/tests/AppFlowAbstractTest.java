package ch.vorburger.appviewsnflows.tests;

import org.junit.Assert;
import org.junit.Test;

import ch.vorburger.appviewsnflows.AppFlowAbstract;
import ch.vorburger.appviewsnflows.FlowException;


/**
 * Unit Test for AppFlowAdapter.
 * 
 * @see AppFlowAbstract
 * @author Michael Vorburger
 */
public class AppFlowAbstractTest {

	@Test(expected=FlowException.class)
	public void testAppFlowAdapterStartStart() {
		AppFlowAbstract flow = new AppFlowAbstract() {
		};
		
		flow.start();
		// starting an already started Flow should fail
		flow.start();
		Assert.fail("Should have failed");
	}
}
