package ch.vorburger.blueprint.common.data.dyn;

import ch.vorburger.blueprint.common.data.DataProp;
import ch.vorburger.blueprint.common.data.DataType;

/**
 * Dynamic (i.e. created at run-time, non-static) DataProp.
 * 
 * @author Michael Vorburger
 */
public class DynDataProp implements DataProp {

	private final DynDataStruct struct;
	private final String name;
	private final int index;
	private DataType dataType = NullDataType.INSTANCE;
	private boolean isMultiple = false;
	private boolean isRequired = false;

	// Note that this is package local - there is no need to expose it
	// TODO Make this package local instead of protected if dyn & statc are merged?
	protected DynDataProp(DynDataStruct struct, String name) {
		super();
		this.struct = struct;
		this.name = name;
		this.index = struct.index++;

		struct.addProperty(this);
	}

	@Override
	public String name() {
		return name;
	}

	// Note that this is package local - there is no need to expose it
	int index() {
		return index;
	}

	// Note that this is package local - there is no need to expose it
	DynDataStruct struct() {
		return struct;
	}

	@Override
	public DataType type() {
		return dataType;
	}

	public DynDataProp type(DataType dataType) {
		this.dataType = dataType;
		return this;
	}

	public DynDataProp type(Class<?> javaClassDataType) {
		type(JavaDataTypes.get(javaClassDataType));
		return this;
	}

	@Override
	public boolean isMultiple() {
		return isMultiple;
	}

	public DynDataProp multiple() {
		isMultiple = true;
		return this;
	}

	@Override
	public boolean isRequired() {
		return isRequired;
	}

	public DynDataProp required() {
		isRequired = true;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DynDataProp:").append(struct.name()).append(".").append(name);
		return builder.toString();
	}

}
