package ch.vorburger.models.core.meta.gen;

import ch.vorburger.models.core.id.ThingWithId;
import ch.vorburger.models.core.meta.mixins.annotated.gen.NamedAnnotatedThing;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface NamedThingInClass extends NamedThing, ThingWithId<NamedThingInClassId> {

	Class parent();
}
