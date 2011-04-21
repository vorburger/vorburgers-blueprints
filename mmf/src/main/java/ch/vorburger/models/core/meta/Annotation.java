package ch.vorburger.models.core.meta;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface Annotation {

	AnnotationType type();
	
	// TODO I'd like the type of the value not to be String but be determined by the type of the Annotation.. how?!
	String value();
}
