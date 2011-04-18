package ch.vorburger.blueprint.common.data.dyn;

import java.util.Collection;
import java.util.LinkedList;

import ch.vorburger.blueprint.common.data.DataProp;
import ch.vorburger.blueprint.common.data.DataStruct;
import ch.vorburger.blueprint.common.data.DataStructObject;

/**
 * Dynamic DataStructObject instance.
 * 
 * Note that this is a package local implementation class - there is no need to expose it.
 * 
 * @author Michael Vorburger
 */
class DynDataStructObject implements DataStructObject {

	private final DynDataStruct dataStruct;
	private final Object[] properties;

	
	DynDataStructObject(DynDataStruct dataStruct) {
		super();
		this.dataStruct = dataStruct;
		properties = new Object[dataStruct.properties().size()];
		for (DataProp p : dataStruct.properties().values()) {
			if (p.isMultiple()) {
				
			}
		}
	}
	
	@Override
	public DataStruct struct() {
		return dataStruct;
	}

	
	@Override
	public Object getPropertyValue(String propertyName) {
		int i = index(propertyName);
		if (properties[i] == null && dataStruct.properties().get(propertyName).isMultiple()) {
			properties[i] = newMultipleValue();
		}
		return properties[i];
	}

	@Override
	public DataStructObject setPropertyValue(String propertyName, Object propertyValue) {
		properties[index(propertyName)] = propertyValue;
		return this;
	}

	@Override
	public void addPropertyValue(String multiplePropertyName, Object propertyValueToAdd) {
		int i = index(multiplePropertyName);
		@SuppressWarnings("unchecked") Collection<Object> multiplePropertyValues = (Collection<Object>) properties[i];
		if (multiplePropertyValues == null) {
			multiplePropertyValues = newMultipleValue(); 
			properties[i] = multiplePropertyValues;
		}
		multiplePropertyValues.add(propertyValueToAdd);
	}

	private LinkedList<Object> newMultipleValue() {
		return new LinkedList<Object>();
	}
	
	private int index(String propertyName) {
		DataProp p = dataStruct.properties().get(propertyName);
		if (p == null) {
			throw new IllegalArgumentException(dataStruct.toString() + " doesn't have property name: " + propertyName + ", only: " + dataStruct.properties().keySet());
		}
		DynDataProp dp = (DynDataProp) p;
		return dp.index();
	}

	
	@Override
	public Object getPropertyValue(DataProp property) {
		return properties[index(property)];
	}

	@Override
	public DataStructObject setPropertyValue(DataProp property, Object propertyValue) {
		properties[index(property)] = propertyValue;
		return this;
	}
	
	private int index(DataProp property) {
		DynDataProp dp = (DynDataProp) property;
		if (!dp.struct().equals(dataStruct)) {
			throw new IllegalArgumentException(property.toString() + " is not Property of this Struct: " + dataStruct.toString());
		}
		return dp.index();
	}
}
