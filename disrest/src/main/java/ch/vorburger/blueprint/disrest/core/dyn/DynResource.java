package ch.vorburger.blueprint.disrest.core.dyn;

import ch.vorburger.blueprint.disrest.core.Property;
import ch.vorburger.blueprint.disrest.core.Resource;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
@SuppressWarnings("rawtypes")
public interface DynResource extends Resource {

	Property property(String name);
	
	// TODO Operation operation(String name);

}
