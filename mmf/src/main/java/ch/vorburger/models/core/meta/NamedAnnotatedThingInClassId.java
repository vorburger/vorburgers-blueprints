package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.id.Id;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface NamedAnnotatedThingInClassId extends Id {

	String className();
	
	String name();
}
