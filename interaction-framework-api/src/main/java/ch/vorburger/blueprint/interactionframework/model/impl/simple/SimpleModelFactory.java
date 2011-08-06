package ch.vorburger.blueprint.interactionframework.model.impl.simple;

import java.util.Map;
import java.util.WeakHashMap;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.Entity;
import ch.vorburger.blueprint.interactionframework.model.EntityId;
import ch.vorburger.blueprint.interactionframework.model.ModelFactory;
import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;

/**
 * Factory for the Simple Model Implementation.
 * 
 * This "simple" implementation does not wrap any other system (such as EMF) or have anything to do
 * with actual Java Types and Reflection; it is just a simple fully dynamic model implementation.
 * 
 * @author Michael Vorburger
 */
public class SimpleModelFactory implements ModelFactory {

	// TODO Move out to somewhere like ch.vorburger.blueprint.utils?
	static abstract class Cache<Key, Value> {
		Map<Key, Value> cache = new WeakHashMap<Key, Value>();
		Value get(Key key) {
			Value value = cache.get(key);
			if (value == null) {
				synchronized (this) {
					value = create(key);
					cache.put(key, value);
				}
			}
			return value;
		}
		
		abstract protected Value create(Key key);
	}
	
	private Cache<DataStructType, DataStructTypeImplINTERNAL> dataStructTypeImplCache = new Cache<DataStructType, DataStructTypeImplINTERNAL>() {
		@Override
		protected DataStructTypeImplINTERNAL create(DataStructType key) {
			return new DataStructTypeImplINTERNAL(key);
		}
		
	};
	
	@Override
	public DataStruct newDataStruct(DataStructType type) {
		DataStructTypeImplINTERNAL typeImpl = dataStructTypeImplCache.get(type);
		return new DataStructImplINTERNAL(typeImpl);
	}

	
	private Cache<EntityType, EntityTypeImplINTERNAL> entityTypeImplCache = new Cache<EntityType, EntityTypeImplINTERNAL>() {
		@Override
		protected EntityTypeImplINTERNAL create(EntityType key) {
			return new EntityTypeImplINTERNAL(key);
		}
	};
	
	@Override
	public Entity newEntity(EntityType type) {
		EntityTypeImplINTERNAL typeImpl = entityTypeImplCache.get(type);
		return new EntityImplINTERNAL(typeImpl);
	}

	@Override
	public EntityId newEntityId(EntityType type) {
		return new EntityIdImplINTERNAL((EntityTypeImplINTERNAL) type);
	}

// This should not be needed?
//	@Override
//	public Property<?> newProperty(PropertyType type) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
