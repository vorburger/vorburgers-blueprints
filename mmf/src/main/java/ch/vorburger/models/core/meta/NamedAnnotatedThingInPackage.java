package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.id.ThingWithId;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface NamedAnnotatedThingInPackage extends NamedAnnotatedThing, ThingWithId<NamedAnnotatedThingInPackageId> {

	Package parent();
	
}
