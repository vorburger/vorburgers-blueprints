package ch.vorburger.blueprint.disrest.core.dyn.meta;

import java.util.List;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface ResourceType extends DataOrResourceType {

	String name();
	
	List<PropertyType> properties();
	
	List<OperationType> operation();
	
	PropertyType idProperty();
	
}
