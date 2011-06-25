package ch.vorburger.blueprint.interactionframework.odata4j.example;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityRepository;
import ch.vorburger.blueprint.interactionframework.odata4j.AbstractInteractionFrameworkODataProducerImpl;


public class ExampleInteractionFrameworkODataProducerImpl extends AbstractInteractionFrameworkODataProducerImpl {

	public ExampleInteractionFrameworkODataProducerImpl(EntityRepository repo, String namespace) {
		super(repo, namespace);
	}

}
