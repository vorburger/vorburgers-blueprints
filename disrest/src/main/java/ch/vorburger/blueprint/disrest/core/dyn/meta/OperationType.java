package ch.vorburger.blueprint.disrest.core.dyn.meta;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface OperationType {

	// TODO argument can be either a ResourceType OR a (list of) simple dataTypes... e.g. Library.searchBooks
	ResourceType argumentType();
	
	ResourceType resultType();
}
