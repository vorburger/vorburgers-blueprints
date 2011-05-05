package ch.vorburger.blueprint.disrest.core.statc;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * TODO Doc
 *
 * @author Michael Vorburger <mike@vorburger.ch>
 */
@Target(METHOD) 
@Retention(RUNTIME)
public @interface Id {

}
