package ch.vorburger.models.core.meta.gen;

import java.util.Map;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface Object {

	Class klass();
	
	Map<Field, Object> fields();
	
	// TODO Method
}
