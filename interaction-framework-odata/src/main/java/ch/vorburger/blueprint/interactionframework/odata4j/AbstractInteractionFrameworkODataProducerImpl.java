package ch.vorburger.blueprint.interactionframework.odata4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.metamodel.SingularAttribute;

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
import org.odata4j.producer.InlineCount;
import org.odata4j.producer.ODataProducer;
import org.odata4j.producer.QueryInfo;
import org.odata4j.producer.Responses;
import org.odata4j.producer.exceptions.NotFoundException;
import org.odata4j.producer.exceptions.ServerErrorException;
import org.odata4j.producer.inmemory.InMemoryProducer;
import org.odata4j.producer.jpa.JPAProducer;

import ch.vorburger.blueprint.interactionframework.model.Entity;
import ch.vorburger.blueprint.interactionframework.model.EntityId;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityMetadata;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityNotFoundException;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityRepository;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityRepositoryQuery;
import ch.vorburger.blueprint.interactionframework.model.repo.RepositoryException;

/**
 * ODataProducer on top of the EntityRepository & EntityMetadata.
 * 
 * @see InMemoryProducer
 * @see JPAProducer
 * 
 * @author Michael Vorburger
 */
public abstract class AbstractInteractionFrameworkODataProducerImpl implements ODataProducer {

	private final EntityRepository repo;
	private final EntityMetadata entityMetadata;
	
	private EdmBuilder edmBuilder;
	private EdmDataServices metadata;

	public AbstractInteractionFrameworkODataProducerImpl(EntityRepository repo, String namespace) {
		super();
		this.repo = repo;
		entityMetadata = repo.getMetadata();
		this.edmBuilder = new EdmBuilder(entityMetadata, namespace);
	}

	@Override
	public EdmDataServices getMetadata() {
		if (metadata == null) {
			metadata = edmBuilder.buildEdm();
		}
		return metadata;
	}

	protected OEntity toOEntity(EdmEntitySet oEntitySet, Entity mEntity, List<EntitySimpleProperty> expand) {
		final List<OProperty<?>> oProperties = new ArrayList<OProperty<?>>();
		final List<OLink> oLinks = new ArrayList<OLink>();

		for (PropertyType mPropertyType : mEntity.getDataStructType().getProperties()) {
			Property<?> mProperty = mEntity.getProperty(mPropertyType);
			String name = mPropertyType.getName();
			EdmType type = EdmBuilder.toEdmType(mPropertyType);
			Object value = mProperty.getValue();
			oProperties.add(OProperties.simple(name, type, value));
		}

		if (expand != null && !expand.isEmpty()) {
			// @see InMemoryProducer.toOEntity() & JPAProducer
			throw new UnsupportedOperationException("Property Expand not yet supported"); // TODO
		}

		OEntityKey returnedEntityKey = toOEntityKey(mEntity);
		return OEntities.create(oEntitySet, returnedEntityKey, oProperties, oLinks);
	}

	protected OEntityKey toOEntityKey(Entity mEntity) {
		// TODO Unit Test this!
		Map<String, Object> oKeyMap = new HashMap<String, Object>();
		Set<Entry<String, Property<?>>> keyProperties = mEntity.getIdentity().getPropertyMap().entrySet();
		for (Entry<String, Property<?>> entry : keyProperties) {
			oKeyMap.put(entry.getKey(), entry.getValue().getValue());
		}
		return OEntityKey.create(oKeyMap);
	}

	protected EntityId toMEntityId(String entitySetName, OEntityKey entityKey) {
		// TODO Unit Test this!

		// TODO Implement this.. which Factory to use to create new EntityId?
		return null;
	}
	
	@Override
	public EntityResponse getEntity(String entitySetName, OEntityKey entityKey, QueryInfo queryInfo) {
		EntityId mEntityId = toMEntityId(entitySetName, entityKey);

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
		
		OEntity oEntity = toOEntity(getMetadata().getEdmEntitySet(entitySetName), mEntity, queryInfo.expand);
		return Responses.entity(oEntity);
	}

	@Override
	public EntitiesResponse getEntities(String oEntitySetName, QueryInfo oQueryInfo) {
		EntityRepositoryQuery mQuery = new EntityRepositoryQuery();

		// TODO This isn't entirely right... we should have a List-Resource definition, and use that!
		EntityType mEntityType = entityMetadata.getEntityType(oEntitySetName);

		mQuery.startPosition = oQueryInfo.skip;
		mQuery.maxResults = oQueryInfo.top;
		
		 // TODO Transform OData Filter into mQuery.filter (FilterExpression)
	    if (oQueryInfo.filter != null) {
			throw new UnsupportedOperationException("Filters not yet supported");
	    }

		Integer inlineCount = null;
		if (oQueryInfo.inlineCount == InlineCount.ALLPAGES) {
			throw new UnsupportedOperationException("inlineCount (doTotalCount) not yet supported");
			// inlineCount = ...;
		}
	    
		// TODO Ordering!!!
		
		List<Entity> mEntities = repo.find(mEntityType, mQuery);

		List<EntitySimpleProperty> expand = null; // TODO Expand stuff!
		
		final EdmEntitySet oEntitySet = getMetadata().getEdmEntitySet(oEntitySetName);
		final List<OEntity> entitiesList = new ArrayList<OEntity>(mEntities.size());
		for (Entity mEntity : mEntities) {
			entitiesList.add(toOEntity(oEntitySet, mEntity, expand));
		}
		
		String skipToken = null;
		// TODO skiptoken stuff
				
		return Responses.entities(entitiesList, oEntitySet, inlineCount, skipToken);
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
	public BaseResponse getNavProperty(String entitySetName, OEntityKey entityKey, String navProp, QueryInfo queryInfo) {
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
