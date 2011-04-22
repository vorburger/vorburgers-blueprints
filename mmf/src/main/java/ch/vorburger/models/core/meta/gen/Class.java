package ch.vorburger.models.core.meta.gen;

import ch.vorburger.models.core.id.MapOfThingsWithIds;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface Class<T> extends Type {

	Class<Object> parentClass();
	Class<T> parentClass(Class<Object> parentClass);
	
	MapOfThingsWithIds<NamedThingInClassId, Field> fields();

	MapOfThingsWithIds<NamedThingInClassId, Method> methods();
	
	T newObject();
}
