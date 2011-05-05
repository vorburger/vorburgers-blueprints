package ch.vorburger.blueprint.disrest.core.dyn.meta;

import ch.vorburger.blueprint.disrest.core.ReferenceRemotingType;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface PropertyType {

	String name();
	
	DataOrResourceType type();
	
	boolean isId();
	
	ReferenceRemotingType referenceRemotingType();
	
}
