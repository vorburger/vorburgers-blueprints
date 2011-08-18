package ch.vorburger.blueprint.interactionframework.model.impl.simple;

import ch.vorburger.blueprint.interactionframework.model.Property;

/* package local */
class PropertyImplINTERNAL<T> implements Property<T> {
	
	private T value;
	private boolean isAvailable = true;

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void setValue(T newValue) {
		this.value = newValue;
	}

	@Override
	public boolean isAvailable() {
		return isAvailable ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PropertyImplINTERNAL))
			return false;
		PropertyImplINTERNAL other = (PropertyImplINTERNAL) obj;
		if (isAvailable != other.isAvailable)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropertyImplINTERNAL [");
		if (value != null)
			builder.append("value=").append(value).append(", ");
		builder.append("isAvailable=").append(isAvailable).append("]");
		return builder.toString();
	}

}
