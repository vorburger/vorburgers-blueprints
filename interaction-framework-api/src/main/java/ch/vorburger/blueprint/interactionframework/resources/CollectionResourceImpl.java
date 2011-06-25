package ch.vorburger.blueprint.interactionframework.resources;

import java.util.Collection;
import java.util.List;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.resources.uri.URI;

public class CollectionResourceImpl<E extends DataStruct> implements CollectionResource<E> /* TODO extends ResourceImpl */ { 

	private final List<E> entries;

	public CollectionResourceImpl(List<E> entries) {
		super();
		this.entries = entries;
	}
	
	@Override
	public URI getURI() {
		throw new UnsupportedOperationException("TODO Implement me!"); // Must implement
	}


	@Override
	public Collection<E> getEntries() {
		return entries;
	}

	@Override
	public Long getCount() {
		throw new UnsupportedOperationException("TODO Implement me!"); // Must implement
	}
	
	@Override
	public Property<?> getProperty(String name) {
		throw new UnsupportedOperationException("TODO Implement me!"); // Must implement
	}

	@Override
	public Property<?> getProperty(PropertyType propertyType) {
		throw new UnsupportedOperationException("TODO Implement me!"); // Must implement
	}

	@Override
	public EntityType getDataStructType() {
		throw new UnsupportedOperationException("TODO Implement me!"); // Must implement
	}

	@Override
	public Resource addResource(Resource newResource) {
		throw new UnsupportedOperationException("TODO Implement me!"); // Must implement
	}

}
