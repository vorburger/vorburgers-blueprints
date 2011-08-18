package ch.vorburger.blueprint.interactionframework.model.meta.simple;

import ch.vorburger.blueprint.interactionframework.model.meta.DataType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

/**
 * Implementation of PropertyType.
 * 
 * This is a typical simple bean style implementation. It will be useful for many use cases. It is
 * however by not means necessarily the only available/possible implementation; typical alternative
 * implementation is a wrapper around some other exists type meta system.
 * 
 * @author Michael Vorburger
 */
public class PropertyTypeImpl implements PropertyType {

	private String name;
	private DataType valueDataType;

	public PropertyTypeImpl(String name, DataType valueDataType) {
		this.name = name;
		this.valueDataType = valueDataType;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public DataType getValueType() {
		return valueDataType;
	}

	public void setValueType(DataType valueType) {
		this.valueDataType = valueType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((valueDataType == null) ? 0 : valueDataType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PropertyType))
			return false;
		PropertyType other = (PropertyType) obj;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		if (valueDataType == null) {
			if (other.getValueType() != null)
				return false;
		} else if (!valueDataType.equals(other.getValueType()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropertyTypeImpl [name=").append(name).append(", valueType=").append(valueDataType).append("]");
		return builder.toString();
	}

}
