package ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel.datatypes;

import ch.vorburger.blueprint.disrest.core.DataType;

/**
 * ISBN Datatype (Sample/Test).
 * 
 * Internally a Long (not a String). 
 *
 * @see http://www.isbn.org/standards/home/isbn/us/isbnqa.asp
 *
 * @author Michael Vorburger
 */
public interface ISBN extends DataType<Long> {

	// TODO code some regexp to allow only numbers and hyphen, and parsing
	
}
