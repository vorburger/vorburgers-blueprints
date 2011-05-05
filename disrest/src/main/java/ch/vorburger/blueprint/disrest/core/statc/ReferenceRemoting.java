package ch.vorburger.blueprint.disrest.core.statc;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import ch.vorburger.blueprint.disrest.core.ReferenceRemotingType;

/**
 * Annotation specifying the ReferenceRemotingType for Reference Properties.
 *
 * @see ReferenceRemotingType
 * 
 * @author Michael Vorburger
 */
@Target(METHOD) 
@Retention(RUNTIME)
public @interface ReferenceRemoting {

	ReferenceRemotingType value();
	 
}
