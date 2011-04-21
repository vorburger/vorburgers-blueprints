package ch.vorburger.models.core.meta;

import ch.vorburger.models.plus.CoreSimpleTypes;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface Field extends NamedAnnotatedThing {

	/**
	 * Field name is a {@link CoreSimpleTypes#MID} - it cannot start with an underscore (that's
	 * reserved for built-in field names, e.g. _id).
	 */
	// TODO how to CoreSimpleTypes.MID should be annotated here - and restriction enforced at runtime?! but that should be in plus, not backed into the core..
	@Override
	String name();
}
