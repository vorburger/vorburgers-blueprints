package ch.vorburger.models.core.meta.gen;

import ch.vorburger.models.core.id.Id;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface NamedAnnotatedThingInPackageId extends Id {

	String packageName();
	
	String name();
}
