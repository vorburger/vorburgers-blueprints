package ch.vorburger.blueprint.disrest.core.dyn;

import ch.vorburger.blueprint.disrest.core.Property;
import ch.vorburger.blueprint.disrest.core.Resource;
import ch.vorburger.blueprint.disrest.core.dyn.meta.OperationType;
import ch.vorburger.blueprint.disrest.core.dyn.meta.ResourceType;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
@SuppressWarnings("rawtypes")
public interface DynResource extends Resource {

	ResourceType type(); // à la getClass()
	
	Property property(String name);
	
	OperationType operation(String name);

}
