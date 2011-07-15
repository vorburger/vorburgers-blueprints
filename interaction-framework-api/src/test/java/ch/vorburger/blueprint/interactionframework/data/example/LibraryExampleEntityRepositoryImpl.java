package ch.vorburger.blueprint.interactionframework.data.example;

import java.util.List;
import java.util.Map;

import ch.vorburger.blueprint.interactionframework.model.Entity;
import ch.vorburger.blueprint.interactionframework.model.EntityId;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.PropertyImpl;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.meta.DataTypeImpl;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.meta.EntityMetadataImpl;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.meta.PropertyTypeImpl;
import ch.vorburger.blueprint.interactionframework.model.meta.DataType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityMetadata;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityNotFoundException;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityRepository;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityRepositoryQuery;
import ch.vorburger.blueprint.interactionframework.model.repo.RepositoryException;
import ch.vorburger.blueprint.interactionframework.resources.ResourceType;
import ch.vorburger.blueprint.interactionframework.resources.ResourceTypeImpl;

public class LibraryExampleEntityRepositoryImpl implements EntityRepository {

	private static final DataType isbnDataType = new DataTypeImpl(Long.class);
	private static final PropertyType bookISBNType = new PropertyTypeImpl("isbn", isbnDataType);
	// TODO bookTitle
	private static final ResourceType bookType = new ResourceTypeImpl("Book");
	private static final EntityMetadataImpl metadata = new EntityMetadataImpl();
	static {
		bookType.getProperties().add(bookISBNType);
		metadata.getEntityTypesMap().put(bookType.getName(), bookType);
	}

	private Entity firstBookEntity = new Entity() {
		Property<?> isbn = new PropertyImpl<Long>(23878534L);

		@Override
		public Property<?> getProperty(PropertyType propertyType) {
			if (bookISBNType.equals(propertyType)) {
				return isbn;
			}
			throw new UnsupportedOperationException();
		}

		
		@Override
		public Property<?> getProperty(String name) {
			if (name.equals("isbn")) {
				return isbn;
			}
			throw new UnsupportedOperationException(name);
		}
		
		@Override
		public EntityType getDataStructType() {
			return bookType;
		}


		@Override
		public Map<String, Property<?>> getPropertyMap() {
			throw new UnsupportedOperationException();
		}


		@Override
		public EntityId getIdentity() {
			throw new UnsupportedOperationException();
		}
	};

	@Override
	public EntityMetadata getMetadata() {
		return metadata;
	}

	@Override
	public Entity getEntity(EntityId id) throws EntityNotFoundException, RepositoryException {
		// TODO Check at least the Id ?!
		return firstBookEntity;
	}

	@Override
	public List<Entity> find(EntityType type, EntityRepositoryQuery query) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Entity updateEntity(Entity resource) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteEntity(EntityId... ids) {
		throw new UnsupportedOperationException();
	}

}
