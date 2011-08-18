package ch.vorburger.blueprint.interactionframework.model.meta.simple;

import ch.vorburger.blueprint.interactionframework.model.meta.DataType;

/**
 * Implementation of DataType.
 * 
 * This is a typical simple bean style implementation. It will be useful for many use cases. It is
 * however by not means necessarily the only available/possible implementation; typical alternative
 * implementation is a wrapper around some other exists type meta system.
 * 
 * @author Michael Vorburger
 */
public class DataTypeImpl implements DataType {

	private final Class<?> javaType;
	private String name;

	public DataTypeImpl(Class<?> javaType) {
		this.javaType = javaType;
		this.name = javaType.getName();
	}

	/**
	 * This is intentionally protected, as it's only needed in the DataStructTypeImpl, a client can
	 * DataStructTypeImpl because the datatypes for all (non relationship) attributes must have a
	 * Java type.
	 */
	protected DataTypeImpl(String name) {
		this.javaType = null;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Class<?> getJavaClass() {
		return javaType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((javaType == null) ? 0 : javaType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DataType))
			return false;
		DataType other = (DataType) obj;
		if (javaType == null) {
			if (other.getJavaClass() != null)
				return false;
		} else if (!javaType.equals(other.getJavaClass()))
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataTypeImpl [javaType=").append(javaType).append(", name=").append(name).append("]");
		return builder.toString();
	}

}
