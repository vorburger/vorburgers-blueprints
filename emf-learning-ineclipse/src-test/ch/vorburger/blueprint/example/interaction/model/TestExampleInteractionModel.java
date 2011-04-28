package ch.vorburger.blueprint.example.interaction.model;

import junit.framework.Assert;

import org.junit.Test;

import ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelFactory;
import ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home;
import ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User;

/**
 * Basic test for Example Interaction Model.
 *
 * @author Michael Vorburger
 */
public class TestExampleInteractionModel {

	@Test
	public void testExampleInteractionModel() {
		// ExampleinteractionmodelPackageImpl.init(); doesn't actually seem to be be needed
		
		ExampleinteractionmodelFactory factory = ExampleinteractionmodelFactory.eINSTANCE;
		
		User user = factory.createUser();
		user.setUid("michael.vorburger");
		
		Home home = factory.createHome();
		home.setCurrentUser(user);
		
		Assert.assertEquals("michael.vorburger", home.getCurrentUser().getUid());
	}
}
