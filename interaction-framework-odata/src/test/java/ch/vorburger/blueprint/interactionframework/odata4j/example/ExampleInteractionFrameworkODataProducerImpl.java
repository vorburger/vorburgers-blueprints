package ch.vorburger.blueprint.interactionframework.odata4j.example;
import ch.vorburger.blueprint.interactionframework.odata4j.AbstractInteractionFrameworkODataProducerImpl;
import ch.vorburger.blueprint.interactionframework.resources.ResourceRepository;


public class ExampleInteractionFrameworkODataProducerImpl extends AbstractInteractionFrameworkODataProducerImpl {

	public ExampleInteractionFrameworkODataProducerImpl(ResourceRepository repo, String namespace) {
		super(repo, namespace);
	}

}
