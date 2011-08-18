package ch.vorburger.blueprint.interactionframework.model.impl.simple;

import ch.vorburger.blueprint.interactionframework.model.meta.DataType;
import ch.vorburger.blueprint.interactionframework.model.meta.simple.PropertyTypeImpl;

/* package local */
class PropertyTypeImplINTERNAL extends PropertyTypeImpl {

	private final int idx;
	
	public PropertyTypeImplINTERNAL(String name, DataType valueType, int idx) {
		super(name, valueType);
		this.idx = idx;
	}

	/* package local, NOT public */
	int idx() {
		return idx;
	}
}
