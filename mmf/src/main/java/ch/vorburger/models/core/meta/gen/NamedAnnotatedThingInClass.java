package ch.vorburger.models.core.meta.gen;

import ch.vorburger.models.core.id.ThingWithId;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface NamedAnnotatedThingInClass extends NamedAnnotatedThing, ThingWithId<NamedAnnotatedThingInClassId> {

	Class parent();
}
