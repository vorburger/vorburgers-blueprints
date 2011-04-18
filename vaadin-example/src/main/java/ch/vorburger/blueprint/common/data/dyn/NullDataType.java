package ch.vorburger.blueprint.common.data.dyn;

import ch.vorburger.blueprint.common.data.DataType;

/**
 * Null Object for DataType, used as default before a datatype is set on a Property.
 * 
 * Note that this is a package local implementation class - there is no need to expose it.
 *
 * @author Michael Vorburger
 */
class NullDataType implements DataType {
	public static final DataType INSTANCE = new NullDataType();

	private NullDataType() {
		super();
	}
	
	@Override
	public String name() {
		return "VOID";
	}

	@Override
	public Class<Void> javaType() {
		return Void.TYPE;
	}

}
