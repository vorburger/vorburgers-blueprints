package ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel;

import ch.vorburger.blueprint.disrest.core.Property;
import ch.vorburger.blueprint.disrest.core.Resource;
import ch.vorburger.blueprint.disrest.core.statc.Id;
import ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel.datatypes.Email;

/**
 * User Resource (Sample/Test).
 *
 * @author Michael Vorburger
 */
public interface User extends Resource {

	// NOTE This is the interaction model, the data (!) model could use another type of ID for the back-end User.
	// NOTE This is the interaction model, the data (!) model probably has additional attributes such as boolean isAdmin & isActive, which we don't need/want to expose here.

	@Id
	Property<Email> id();

	// NOTE Password is not a property of this kind of User...
	void changePassword(UserPasswordChange userPasswordChange);

	/**
	 * User Password Change Resource (Sample/Test).
	 * 
	 * NOTE: This has again no Id, and is not going to be 'reference-able' (no GET).
	 */
	// TODO Should this be a special type, not Resource, but OperationArgument? Sometimes OperationArgument will be Resources... or never, as then they'd have to be Property?! 
	public interface UserPasswordChange extends Resource {
		Property<String> oldPassword();

		Property<String> newPassword();
	}
}
