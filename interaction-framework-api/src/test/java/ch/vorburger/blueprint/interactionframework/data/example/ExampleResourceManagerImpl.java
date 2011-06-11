package ch.vorburger.blueprint.interactionframework.data.example;

import java.util.Collection;

import ch.vorburger.blueprint.interactionframework.data.Entity;
import ch.vorburger.blueprint.interactionframework.data.Property;
import ch.vorburger.blueprint.interactionframework.data.PropertyImpl;
import ch.vorburger.blueprint.interactionframework.data.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.data.meta.EntityTypeImpl;
import ch.vorburger.blueprint.interactionframework.data.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.data.meta.PropertyTypeImpl;
import ch.vorburger.blueprint.interactionframework.data.meta.DataType;
import ch.vorburger.blueprint.interactionframework.data.meta.DataTypeImpl;
import ch.vorburger.blueprint.interactionframework.resources.CollectionResource;
import ch.vorburger.blueprint.interactionframework.resources.Resource;
import ch.vorburger.blueprint.interactionframework.resources.ResourceManager;
import ch.vorburger.blueprint.interactionframework.resources.URI;

class ExampleResourceManagerImpl implements ResourceManager {

	private static final DataType isbnDataType = new DataTypeImpl(Long.class);
	private static final EntityType bookType = new EntityTypeImpl("Book");
	private static final PropertyType bookISBNType = new PropertyTypeImpl("isbn", isbnDataType);
	static {
		bookType.getProperties().add(bookISBNType);
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
		public EntityType getEntityType() {
			return bookType;
		}

		@Override
		public URI getURI() {
			return new URI() {
				@Override
				public String toString() {
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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Property<?> getProperty(PropertyType propertyType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EntityType getEntityType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Resource addResource(Resource newResource) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public Collection<Entity> getEntries() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

	};

	@Override
	public Resource getMetadata() {
		// TODO Auto-generated method stub
		return null;
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
	public Entity newEntity(EntityType type) {
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
