package ch.vorburger.blueprint.interactionframework.data.example;

import ch.vorburger.blueprint.interactionframework.resources.ResourceManager;

public class InteractionFrameworkExampleResources {

	static public ResourceManager newExampleResourceManager() {
		return new ExampleResourceManagerImpl();
	}
}
