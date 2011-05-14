package ch.vorburger.learnapt;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An example Annotation.
 * 
 * @see http://www.javaspecialists.eu/archive/Issue167.html
 * 
 * @author vorburger
 */
@Inherited // necessary so that the subclasses inherit the annotation
@Documented // annotation appears in the JavaDocs
@Retention(RetentionPolicy.SOURCE) // annotation will only be available to APT and not at runtime with reflection
@Target(ElementType.TYPE) // annotation is only allowed for classes
public @interface SomeAnnotation {

}
