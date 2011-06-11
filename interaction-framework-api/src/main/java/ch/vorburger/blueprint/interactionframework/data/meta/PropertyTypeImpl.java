package ch.vorburger.blueprint.interactionframework.data.meta;

public class PropertyTypeImpl implements PropertyType {

	private final String name;
	private final DataType valueType;

	public PropertyTypeImpl(String name, DataType valueType) {
		super();
		this.name = name;
		this.valueType = valueType;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public DataType getValueType() {
		return valueType;
	}

}
