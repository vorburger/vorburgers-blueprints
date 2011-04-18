package ch.vorburger.blueprint.common.data.statc;

import ch.vorburger.blueprint.common.data.dyn.DynDataStruct;

/**
 * DataStruct with a statically typed interface API.
 * 
 * @param <StructT> Java Type of statically typed Data Structure
 * 
 * @author Michael Vorburger
 */
public class StaticDataStruct<StructT> extends DynDataStruct {

	public StaticDataStruct(Class<StructT> klass) {
		super("StaticDataStruct:" + klass.getName());
	}

}
