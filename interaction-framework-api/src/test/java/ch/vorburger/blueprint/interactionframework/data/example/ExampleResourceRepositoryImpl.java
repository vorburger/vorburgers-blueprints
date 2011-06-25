package ch.vorburger.blueprint.interactionframework.data.example;

import java.util.Collection;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.PropertyImpl;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.meta.DataTypeImpl;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.meta.PropertyTypeImpl;
import ch.vorburger.blueprint.interactionframework.model.meta.DataType;
import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.resources.CollectionResource;
import ch.vorburger.blueprint.interactionframework.resources.Metadata;
import ch.vorburger.blueprint.interactionframework.resources.MetadataImpl;
import ch.vorburger.blueprint.interactionframework.resources.Resource;
import ch.vorburger.blueprint.interactionframework.resources.ResourceRepository;
import ch.vorburger.blueprint.interactionframework.resources.ResourceType;
import ch.vorburger.blueprint.interactionframework.resources.ResourceTypeImpl;
import ch.vorburger.blueprint.interactionframework.resources.uri.URI;

public class ExampleResourceRepositoryImpl implements ResourceRepository {

	private static final DataType isbnDataType = new DataTypeImpl(Long.class);
	private static final PropertyType bookISBNType = new PropertyTypeImpl("isbn", isbnDataType);
	private static final ResourceType bookType = new ResourceTypeImpl("Book");
	private static final Metadata metadata = new MetadataImpl();
	static {
		bookType.getProperties().add(bookISBNType);
		metadata.getResourceTypes().add(bookType);
	}

	private Resource firstBookResource = new Resource() {
		Property<?> isbn = new PropertyImpl<Long>(23878534L);

		@Override
		public Property<?> getProperty(String name) {
			if (name.equals("isbn")) {
				return isbn;
			}
			throw new UnsupportedOperationException(name);
		}

		@Override
		public Property<?> getProperty(PropertyType propertyType) {
			if (bookISBNType.equals(propertyType)) {
				return isbn;
			}
			throw new UnsupportedOperationException();
		}

		@Override
		public EntityType getDataStructType() {
			return bookType;
		}

		@Override
		public URI getURI() {
			return new URI() {
				@Override
				public String toString() {
					// TODO this is wrong - only relative URL should be here, final URI must be composed outside
					return "http://localhost/books/{1}";
				}
			};
		}
	};

	private CollectionResource allBooksResource = new CollectionResource() {
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

	};

	@Override
	public Metadata getMetadata() {
		return metadata;
	}

	@Override
	public Resource getResource(URI uri) {
		// Cheap cheap!
		if (uri.toString().contains("/books/{")) {
			return (Resource) newEntity(bookType);
		} else if (uri.toString().contains("/books")) {
			return allBooksResource;
		}
		throw new UnsupportedOperationException(uri.toString());
	}

	@Override
	public DataStruct newEntity(DataStructType type) {
		if (type.equals(bookType)) {
			return firstBookResource;
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateResource(Resource resource) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteResource(URI uri) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Resource getHomepage() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
