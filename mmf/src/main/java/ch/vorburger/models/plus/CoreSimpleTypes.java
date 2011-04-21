package ch.vorburger.models.plus;

import ch.vorburger.models.core.meta.NamedThing;
import ch.vorburger.models.core.meta.SimpleType;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public enum CoreSimpleTypes implements SimpleType {
	// TODO not sure which package this should be in, and what/how it's going to be used for..

	// TODO build something into the framework which enforces this?!  RegExp shouldn't be Doc only, but in annotation!!

	/**
	 * An ID is a type which corresponds to the following regexp ...
	 */
	// TODO Define exact Regexp in doc above!
	ID,
	
	/**
	 * Model ID.
	 * MIDs can contain, but not start with, an underscore (which is reserved for built-in system IDs). 
	 */
	MID;

	public NamedThing name(String newName) {
		throw new UnsupportedOperationException("Cannot change name of built-in core simple type" + name());
	}
	
}
