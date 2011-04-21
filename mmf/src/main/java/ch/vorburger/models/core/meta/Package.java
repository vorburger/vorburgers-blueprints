package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.id.MapOfThingsWithIds;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface Package extends NamedAnnotatedThing {

	MapOfThingsWithIds<NamedAnnotatedThingInPackageId, Class> classes();

	MapOfThingsWithIds<NamedAnnotatedThingInPackageId, SimpleType> simpleTypes();

	MapOfThingsWithIds<NamedAnnotatedThingInPackageId, AnnotationType> annotationTypes();

}
