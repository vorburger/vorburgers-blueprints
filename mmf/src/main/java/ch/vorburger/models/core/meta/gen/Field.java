package ch.vorburger.models.core.meta.gen;

import ch.vorburger.models.core.meta.CoreSimpleTypes;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface Field extends NamedThingInClass {

	Type type();
	
	boolean isMultiple();
	
	/**
	 * Field name is a {@link CoreSimpleTypes#MID} - it cannot start with an underscore (that's
	 * reserved for built-in field names, e.g. _id).
	 */
	// TODO how to CoreSimpleTypes.MID should be annotated here - and restriction enforced at runtime?! but that should be in plus, not backed into the core..
	@Override
	String name();
	
	@Override
	Field name(String name);

}
