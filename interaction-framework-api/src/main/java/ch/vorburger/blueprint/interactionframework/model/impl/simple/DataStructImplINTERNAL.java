package ch.vorburger.blueprint.interactionframework.model.impl.simple;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

/* package local */
class DataStructImplINTERNAL implements DataStruct {

	private final DataStructTypeImplINTERNAL type;
	private final @SuppressWarnings("rawtypes") Property[] properties;

	DataStructImplINTERNAL(DataStructTypeImplINTERNAL type) {
		this.type = type;
		this.properties = new Property[type.getPropertyTypesMap().size()];
	}

	@Override
	public DataStructType getDataStructType() {
		return type;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> Property<T> getProperty(PropertyType propertyType) {
		int idx = getPropertyTypeIndex(propertyType);
		if (properties[idx] == null) {
			properties[idx] = new PropertyImplINTERNAL<T>();
		}
		return properties[idx];
	}

	private int getPropertyTypeIndex(PropertyType propertyType) {
		PropertyTypeImplINTERNAL propertyTypeImpl;
		if (propertyType instanceof PropertyTypeImplINTERNAL) {
			propertyTypeImpl = (PropertyTypeImplINTERNAL) propertyType;
		} else {
			PropertyType propertyType2 = type.getPropertyTypesMap().get(propertyType.getName());
			if (propertyType2 == null)
				throw new IllegalArgumentException(propertyType.toString() + " not found in the " + type.toString());
			// Now the cast must succeed - because in the constructor we initialized the type with
			// our own DataStructTypeImpl copy. A ClassCastException here is an implementation bug,
			// not an error in the caller of this class.
			propertyTypeImpl = (PropertyTypeImplINTERNAL) propertyType2;
		}
		return propertyTypeImpl.idx();
	}

	@Override
	public <T> Property<T> getProperty(String name) {
		return getProperty(type.getPropertyTypesMap().get(name));
	}

	@Override
	public Map<String, Property<?>> getPropertyMap() {
		HashMap<String, Property<?>> map = new HashMap<String, Property<?>>(properties.length);
		Collection<PropertyType> properyTypes = type.getPropertyTypesMap().values();
		for (PropertyType propertyType : properyTypes) {
			map.put(propertyType.getName(), getProperty(propertyType));
		}
		return Collections.unmodifiableMap(map);
	}

	// TODO toString() & equals() & hashCode() !!!
}
