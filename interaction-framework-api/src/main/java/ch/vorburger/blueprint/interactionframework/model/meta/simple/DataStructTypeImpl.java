package ch.vorburger.blueprint.interactionframework.model.meta.simple;

import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.DataType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

/**
 * Implementation of DataStructType.
 * 
 * This is a typical simple bean style implementation. It will be useful for many use cases. It is
 * however by not means necessarily the only available/possible implementation; typical alternative
 * implementation is a wrapper around some other exists type meta system.
 * 
 * @author Michael Vorburger
 */
public class DataStructTypeImpl extends DataTypeImpl implements DataStructType {

	private Map<String, PropertyType> propertyTypesMap = new HashMap<String, PropertyType>();

	protected DataStructTypeImpl(Class<DataStruct> aClass) {
		super(aClass);
	}

	public DataStructTypeImpl(String name) {
		super(name);
	}

	@Override
	public Map<String, PropertyType> getPropertyTypesMap() {
		return propertyTypesMap;
	}

	public void addPropertyType(PropertyType propertyType) {
		getPropertyTypesMap().put(propertyType.getName(), propertyType);
	}

	public PropertyTypeImpl addPropertyType(String name, DataType valueDataType) {
		PropertyTypeImpl p = new PropertyTypeImpl(name, valueDataType);
		addPropertyType(p);
		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((propertyTypesMap == null) ? 0 : propertyTypesMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof DataStructType))
			return false;
		DataStructType other = (DataStructType) obj;
		if (propertyTypesMap == null) {
			if (other.getPropertyTypesMap() != null)
				return false;
		} else if (!propertyTypesMap.equals(other.getPropertyTypesMap()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataStructTypeImpl [name=").append(getName()).append(propertyTypesMap.values())
				.append(", getJavaClass()=").append(getJavaClass()).append("]");
		return builder.toString();
	}

}
