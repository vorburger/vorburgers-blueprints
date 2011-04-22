package ch.vorburger.models.core.meta.gen;

import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.meta.gen.id.NamedThingInClassId;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
@SuppressWarnings("restriction")
@javax.annotation.Generated("ClassInterfaceGenerator")
public interface Class<T> extends Type {

	Class<Object> parentClass();
	Class<T> parentClass(Class<Object> parentClass);
	
	MapOfThingsWithIds<NamedThingInClassId, Field> fields();

	MapOfThingsWithIds<NamedThingInClassId, Method> methods();
	
	T newObject();
}
