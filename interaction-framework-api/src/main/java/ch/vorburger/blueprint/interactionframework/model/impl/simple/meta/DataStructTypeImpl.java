package ch.vorburger.blueprint.interactionframework.model.impl.simple.meta;

import java.util.HashSet;
import java.util.Set;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.DataStructImpl;
import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

public class DataStructTypeImpl extends DataStructImpl implements DataStructType {

	private final String name;
	private final Set<PropertyType> properties;

	public DataStructTypeImpl(String name) {
		super();
		this.name = name;
		this.properties = new HashSet<PropertyType>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Set<PropertyType> getProperties() {
		return properties;
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
	public DataStructType getDataStructType() {
        throw new UnsupportedOperationException();
	}

	@Override
	public Class<?> getJavaClass() {
		// TODO When we have static code gen, then this should return a more specific type
		return DataStruct.class;
	}

}
