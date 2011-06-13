package ch.vorburger.blueprint.interactionframework.odata4j;

import org.odata4j.core.OEntity;
import org.odata4j.core.OEntityKey;
import org.odata4j.edm.EdmDataServices;
import org.odata4j.producer.BaseResponse;
import org.odata4j.producer.EntitiesResponse;
import org.odata4j.producer.EntityResponse;
import org.odata4j.producer.ODataProducer;
import org.odata4j.producer.QueryInfo;

import ch.vorburger.blueprint.interactionframework.resources.ResourceRepository;

public abstract class AbstractInteractionFrameworkODataProducerImpl implements ODataProducer {

	private final ResourceRepository repo;
	private EdmBuilder edmBuilder;
	
	public AbstractInteractionFrameworkODataProducerImpl(ResourceRepository repo, String namespace) {
		super();
		this.repo = repo;
		this.edmBuilder = new EdmBuilder(repo, namespace);
	}

	@Override
	public EdmDataServices getMetadata() {
		return edmBuilder.buildEdm();
	}

	@Override
	public EntitiesResponse getEntities(String entitySetName, QueryInfo queryInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityResponse getEntity(String entitySetName, OEntityKey entityKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse getNavProperty(String entitySetName, OEntityKey entityKey, String navProp, QueryInfo queryInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityResponse createEntity(String entitySetName, OEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityResponse createEntity(String entitySetName, OEntityKey entityKey, String navProp, OEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntity(String entitySetName, OEntityKey entityKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mergeEntity(String entitySetName, OEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEntity(String entitySetName, OEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
	}

}
