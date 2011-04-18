package ch.vorburger.blueprint.common.data.dyn;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprint.common.data.DataProp;
import ch.vorburger.blueprint.common.data.DataStruct;

/**
 * Dynamic (i.e. created at run-time, non-static) DataStruct.
 * 
 * @author Michael Vorburger
 */
public class DynDataStruct implements DataStruct {

	private final String name;
	private final Map<String, DataProp> properties = new HashMap<String, DataProp>();
	int index = 0;
	
	public DynDataStruct(String name) {
		super();
		this.name = name;
	}

	/* package-local helper */ void addProperty(DataProp p) {
		properties.put(p.name(), p);
	}

	@Override
	public String name() {
		return name;
	}
	
	@Override
	public Map<String, DataProp> properties() {
		return Collections.unmodifiableMap(properties);
	}

	public DynDataProp newProperty(String name) {
		if (properties.containsKey(name)) {
			throw new IllegalArgumentException(this.name + " already has a " + name);
		}
		DynDataProp p = new DynDataProp(this, name);
		return p;
	}

	@Override
	public Class<?> javaType() {
		return DynDataStruct.class;
	}

	@Override
	public String toString() {
		return name;
	}

}
