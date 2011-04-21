package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.id.MapOfThingsWithIds;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface Class extends Type {

	MapOfThingsWithIds<NamedAnnotatedThingInClassId, Field> fields();

	MapOfThingsWithIds<NamedAnnotatedThingInClassId, Method> methods();
	
	// TODO ??? newObject();
}
