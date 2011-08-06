package ch.vorburger.blueprint.interactionframework.data.example;

import java.util.List;

import ch.vorburger.blueprint.interactionframework.model.Entity;
import ch.vorburger.blueprint.interactionframework.model.EntityId;
import ch.vorburger.blueprint.interactionframework.model.ModelFactory;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.SimpleModelFactory;
import ch.vorburger.blueprint.interactionframework.model.meta.DataType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityMetadata;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.model.meta.simple.DataTypeImpl;
import ch.vorburger.blueprint.interactionframework.model.meta.simple.EntityMetadataImpl;
import ch.vorburger.blueprint.interactionframework.model.meta.simple.EntityTypeImpl;
import ch.vorburger.blueprint.interactionframework.model.meta.simple.PropertyTypeImpl;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityNotFoundException;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityRepository;
import ch.vorburger.blueprint.interactionframework.model.repo.EntityRepositoryQuery;
import ch.vorburger.blueprint.interactionframework.model.repo.RepositoryException;



public class LibraryExampleEntityRepositoryImpl implements EntityRepository {

	private static final DataType isbnDataType = new DataTypeImpl(Long.class);
	private static final PropertyType bookISBNType = new PropertyTypeImpl("isbn", isbnDataType);
	// TODO bookTitle
	private static final EntityTypeImpl bookType = new EntityTypeImpl("Book");
	private static final EntityMetadataImpl metadata = new EntityMetadataImpl();
	static {
		bookType.addPropertyType(bookISBNType);
		metadata.getEntityTypesMap().put(bookType.getName(), bookType);
	}
	
	private static final ModelFactory f = new SimpleModelFactory();
	private static Entity firstBookEntity = f.newEntity(bookType);
	static {
		firstBookEntity.getProperty(bookISBNType).setValue("23878534L");
	}
		
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
	public Entity updateEntity(Entity entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteEntity(EntityId... ids) {
		throw new UnsupportedOperationException();
	}

}
