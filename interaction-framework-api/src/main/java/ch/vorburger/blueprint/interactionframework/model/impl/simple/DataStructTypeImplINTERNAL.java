package ch.vorburger.blueprint.interactionframework.model.impl.simple;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.model.meta.simple.DataStructTypeImpl;

class DataStructTypeImplINTERNAL extends DataStructTypeImpl {

	private final Map<String, PropertyType> propertyTypes;

	public DataStructTypeImplINTERNAL(DataStructType type) {
		super(type.getName());
		HashMap<String, PropertyType> propertyTypesTemp = new HashMap<String, PropertyType>(type.getPropertyTypesMap().size());
		int idx = 0;
		for (PropertyType propertyType : type.getPropertyTypesMap().values()) {
			propertyTypesTemp.put(propertyType.getName(), new PropertyTypeImplINTERNAL(propertyType.getName(), propertyType.getValueType(), idx++));
		}
		this.propertyTypes = Collections.unmodifiableMap(propertyTypesTemp);
		// this.javaClass = type.getJavaClass();  // TODO Is this even needed here?
	}

	@Override
	public Map<String, PropertyType> getPropertyTypesMap() {
		return propertyTypes;
	}
	
	// We shouldn't need to override equals() / hashCode() & toString() here,
	// because the propertyTypes field here is just for the idx in PropertyTypeImplINTERNAL.

}
