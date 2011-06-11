package ch.vorburger.blueprint.interactionframework.data.meta;

public class DataTypeImpl implements DataType {

	private final Class<?> javaType;

	public DataTypeImpl(Class<?> javaType) {
		super();
		this.javaType = javaType;
	}

	@Override
	public Class<?> getJavaType() {
		return javaType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValueType [javaType=").append(javaType).append("]");
		return builder.toString();
	}

}
