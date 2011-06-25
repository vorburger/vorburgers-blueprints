package ch.vorburger.blueprint.interactionframework.odata4j;

import java.util.ArrayList;
import java.util.List;

import org.odata4j.core.OEntities;
import org.odata4j.core.OEntity;
import org.odata4j.core.OEntityId;
import org.odata4j.core.OEntityKey;
import org.odata4j.core.OLink;
import org.odata4j.core.OProperties;
import org.odata4j.core.OProperty;
import org.odata4j.edm.EdmDataServices;
import org.odata4j.edm.EdmEntitySet;
import org.odata4j.edm.EdmType;
import org.odata4j.expression.EntitySimpleProperty;
import org.odata4j.producer.BaseResponse;
import org.odata4j.producer.EntitiesResponse;
import org.odata4j.producer.EntityIdResponse;
import org.odata4j.producer.EntityResponse;
import org.odata4j.producer.ODataProducer;
import org.odata4j.producer.QueryInfo;
import org.odata4j.producer.Responses;
import org.odata4j.producer.exceptions.NotFoundException;
import org.odata4j.producer.exceptions.ServerErrorException;

import ch.vorburger.blueprint.interactionframework.model.Entity;
import ch.vorburger.blueprint.interactionframework.model.EntityId;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityNotFoundException;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityRepository;
import ch.vorburger.blueprint.interactionframework.model.repo.RepositoryException;

public abstract class AbstractInteractionFrameworkODataProducerImpl implements ODataProducer {

	private final EntityRepository repo;
	private EdmBuilder edmBuilder;
	private EdmDataServices metadata;

	public AbstractInteractionFrameworkODataProducerImpl(EntityRepository repo, String namespace) {
		super();
		this.repo = repo;
		this.edmBuilder = new EdmBuilder(repo, namespace);
	}

	@Override
	public EdmDataServices getMetadata() {
		if (metadata == null) {
			metadata = edmBuilder.buildEdm();
		}
		return metadata;
	}

	@Override
	public EntitiesResponse getEntities(String entitySetName, QueryInfo queryInfo) {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public EntityResponse getEntity(String entitySetName, OEntityKey entityKey, QueryInfo queryInfo) {
		EntityId mEntityId = null; // TODO how???

		Entity mEntity;
		try {
			mEntity = repo.getEntity(mEntityId);
		} catch (EntityNotFoundException e) {
			// TODO Should be able to chain e to ServerErrorException for logging higher up!
			// TODO Logging!
			throw new NotFoundException(mEntityId.toString() + " not found");
		} catch (RepositoryException e) {
			// TODO Should be able to chain e to ServerErrorException for logging higher up!
			// TODO Logging!
			throw new ServerErrorException(e.getMessage());
		}

		final EdmEntitySet oEntitySet = getMetadata().getEdmEntitySet(entitySetName);
		final List<OProperty<?>> oProperties = new ArrayList<OProperty<?>>();
		final List<OLink> oLinks = new ArrayList<OLink>();

		for (PropertyType mPropertyType : mEntity.getDataStructType().getProperties()) {
			Property<?> mProperty = mEntity.getProperty(mPropertyType);
			String name = mPropertyType.getName();
			EdmType type = EdmBuilder.toEdmType(mPropertyType);
			Object value = mProperty.getValue();
			oProperties.add(OProperties.simple(name, type, value));
		}

		List<EntitySimpleProperty> expand = queryInfo.expand;
		if (expand != null && !expand.isEmpty()) {
			// @see InMemoryProducer.toOEntity() & JPAProducer
			throw new UnsupportedOperationException(); // TODO
		}

		OEntityKey returnedEntityKey = entityKey; // TODO Ok, or must use EntityKey.create(keyValue)
		OEntity oEntity = OEntities.create(oEntitySet, returnedEntityKey, oProperties, oLinks);
		return Responses.entity(oEntity);
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
	public void updateLink(OEntityId sourceEntity, String targetNavProp, OEntityKey oldTargetEntityKey,
			OEntityId newTargetEntity) {
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
