package ch.vorburger.blueprint.interactionframework.data.example;

import java.util.Collection;
import java.util.Map;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.EntityId;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.resources.CollectionResource;
import ch.vorburger.blueprint.interactionframework.resources.Metadata;
import ch.vorburger.blueprint.interactionframework.resources.Resource;
import ch.vorburger.blueprint.interactionframework.resources.ResourceRepository;
import ch.vorburger.blueprint.interactionframework.resources.uri.URI;

public class LibraryExampleResourceRepositoryImpl implements ResourceRepository {

	private CollectionResource<DataStruct> allBooksResource = new CollectionResource<DataStruct>() {
		@Override
		public URI getURI() {
			return new URI() {
				@Override
				public String toString() {
					return "http://localhost/books/";
				}
			};
		}

		@Override
		public Property<?> getProperty(String name) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Property<?> getProperty(PropertyType propertyType) {
			throw new UnsupportedOperationException();
		}

		@Override
		public EntityType getDataStructType() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Resource addResource(Resource newResource) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Collection<DataStruct> getEntries() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Long getCount() {
			return 1L;
		}

		@Override
		public EntityId getIdentity() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Map<String, Property<?>> getPropertyMap() {
			throw new UnsupportedOperationException();
		}
	};

	@Override
	public Resource getHomepage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Metadata getMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource getResource(URI uri) {
		// Cheap cheap!
		if (uri.toString().contains("/books/{")) {
			return (Resource) newEntity(null/*bookType*/);
		} else if (uri.toString().contains("/books")) {
			return allBooksResource;
		}
		throw new UnsupportedOperationException(uri.toString());
	}

	@Override
	public void updateResource(Resource resource) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteResource(URI uri) {
		throw new UnsupportedOperationException();
	}

	@Override
	public DataStruct newEntity(DataStructType type) {
		throw new UnsupportedOperationException();
	}

}
