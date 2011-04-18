package ch.vorburger.blueprint.common.data.dyn;

import ch.vorburger.blueprint.common.data.DataStruct;
import ch.vorburger.blueprint.common.data.DataStructObject;

/**
 * Factory which can create "dynamic" (non-static) DataStructObject instances.
 * 
 * @author Michael Vorburger
 */
public abstract class DynDataStructObjectFactory {
	private DynDataStructObjectFactory() {
	}

	// TODO why separate dyn & statc packages, actually, and not just one DataStructFactory with two methods?! 
	
	public static DataStructObject create(DataStruct struct) {
		return new DynDataStructObject((DynDataStruct) struct);
	}
}
