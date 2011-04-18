package ch.vorburger.blueprint.common.data;

import java.util.Map;

/**
 * Data Structure.
 * 
 * This is the "descriptor" ('class').
 * 
 * @author Michael Vorburger
 */
public interface DataStruct extends DataType {

	String name();
	
	Map<String, DataProp> properties();

	// TODO oid ?
}
