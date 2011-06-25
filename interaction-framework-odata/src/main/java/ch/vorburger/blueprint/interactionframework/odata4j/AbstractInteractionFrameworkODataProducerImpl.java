package ch.vorburger.blueprint.interactionframework.odata4j;

import org.odata4j.core.OEntity;
import org.odata4j.core.OEntityId;
import org.odata4j.core.OEntityKey;
import org.odata4j.edm.EdmDataServices;
import org.odata4j.producer.BaseResponse;
import org.odata4j.producer.EntitiesResponse;
import org.odata4j.producer.EntityIdResponse;
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
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public EntityResponse getEntity(String entitySetName, OEntityKey entityKey, QueryInfo queryInfo) {
		if (queryInfo != null)
			throw new UnsupportedOperationException(); // TODO
			
		StringBuilder uri = new StringBuilder(entitySetName);
		return null;
	}

	@Override
	public BaseResponse getNavProperty(String entitySetName, OEntityKey entityKey, String navProp, QueryInfo queryInfo) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public EntityResponse createEntity(String entitySetName, OEntity entity) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public EntityResponse createEntity(String entitySetName, OEntityKey entityKey, String navProp, OEntity entity) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public void deleteEntity(String entitySetName, OEntityKey entityKey) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public void mergeEntity(String entitySetName, OEntity entity) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public void updateEntity(String entitySetName, OEntity entity) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public EntityIdResponse getLinks(OEntityId sourceEntity, String targetNavProp) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public void createLink(OEntityId sourceEntity, String targetNavProp, OEntityId targetEntity) {
		throw new UnsupportedOperationException(); // TODO
		
	}

	@Override
	public void updateLink(OEntityId sourceEntity, String targetNavProp, OEntityKey oldTargetEntityKey, OEntityId newTargetEntity) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public void deleteLink(OEntityId sourceEntity, String targetNavProp, OEntityKey targetEntityKey) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public void close() {
	}

}
