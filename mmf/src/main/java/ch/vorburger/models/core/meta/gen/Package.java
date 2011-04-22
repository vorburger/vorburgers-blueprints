package ch.vorburger.models.core.meta.gen;

import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.meta.gen.id.NamedThingInPackageId;
import ch.vorburger.models.core.meta.mixins.annotated.gen.AnnotationType;
import ch.vorburger.nullable.Nullable;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface Package extends NamedThing, Nullable {

	MapOfThingsWithIds<NamedThingInPackageId, Class> classes();

	MapOfThingsWithIds<NamedThingInPackageId, SimpleType> simpleTypes();

	MapOfThingsWithIds<NamedThingInPackageId, AnnotationType> annotationTypes();

}
