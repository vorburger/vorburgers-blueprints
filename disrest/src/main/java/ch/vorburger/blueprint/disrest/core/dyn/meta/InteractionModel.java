package ch.vorburger.blueprint.disrest.core.dyn.meta;

import java.util.List;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface InteractionModel {

	ResourceType home();

	List<ResourceType> resources();
	
}
