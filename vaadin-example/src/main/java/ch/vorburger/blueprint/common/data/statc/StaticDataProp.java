package ch.vorburger.blueprint.common.data.statc;

import ch.vorburger.blueprint.common.data.DataProp;
import ch.vorburger.blueprint.common.data.DataType;
import ch.vorburger.blueprint.common.data.dyn.DynDataProp;

/**
 * Property of a statically typed Data Structure.
 * 
 * @param <StructT> Java Type of statically typed Data Structure
 * @param <PropertyT> Java Type of statically typed Property
 * 
 * @author Michael Vorburger
 */
public class StaticDataProp<StructT, PropertyT> extends DynDataProp implements DataProp {

	public StaticDataProp(StaticDataStruct<StructT> struct, String name) {
		super(struct, name);
	}

	@Override
	public StaticDataProp<StructT, PropertyT> type(DataType dataType) {
		super.type(dataType);
		return this;
	}

	@Override
	public StaticDataProp<StructT, PropertyT> type(Class<?> javaClassDataType) {
		super.type(javaClassDataType);
		return this;
	}

	@Override
	public StaticDataProp<StructT, PropertyT> multiple() {
		super.multiple();
		return this;
	}

	@Override
	public StaticDataProp<StructT, PropertyT> required() {
		super.required();
		return this;
	}
	
}
