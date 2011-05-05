package ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel.datatypes;

import ch.vorburger.blueprint.disrest.core.DataType;

/**
 * Email Datatype (Sample/Test).
 *
 * @author Michael Vorburger
 */
public interface Email extends DataType<String> {

	// TODO code regexp to allow only numbers and hyphen, and parsing
	// TODO some way of expressing that this is typically rendered as a mailto: link
	
}
