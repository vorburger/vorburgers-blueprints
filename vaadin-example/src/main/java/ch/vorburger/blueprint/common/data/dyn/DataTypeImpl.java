package ch.vorburger.blueprint.common.data.dyn;

import ch.vorburger.blueprint.common.data.DataType;

/**
 * Implementation of DataType.
 * 
 * Note that this is a package local implementation class - there is no need to expose it.
 * 
 * @author Michael Vorburger
 */
class DataTypeImpl implements DataType {
	// TODO Confirm that there is no need to expose this and package-local is OK...

	private final String name;
	private final Class<?> javaType;

	public DataTypeImpl(String name, Class<?> javaType) {
		super();
		this.name = name;
		this.javaType = javaType;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public Class<?> javaType() {
		return javaType;
	}

}
