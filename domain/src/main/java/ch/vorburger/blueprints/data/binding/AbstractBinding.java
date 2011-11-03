package ch.vorburger.blueprints.data.binding;

import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprints.data.DataObject;

/**
 * Abstract base class for Binding Implementations.
 *
 * @author Michael Vorburger
 */
public abstract class AbstractBinding implements Binding {

	protected static final char PATH_SEPARATOR = '.';

	@Override
	public abstract void mapFromTo(Map<String, DataObject> dataObjectNameMap) throws BindingException; 

	@Override
	public void mapFromTo(NamedDataObject... namedDataObjects) throws BindingException {
		Map<String, DataObject> dataObjectNameMap = new HashMap<String, DataObject>();
		for (NamedDataObject namedDataObject : namedDataObjects) {
			dataObjectNameMap.put(namedDataObject.name, namedDataObject.dataObject);
		}
		mapFromTo(dataObjectNameMap);
	}
	
	
	public static NamedDataObject newNamedDataObject(String name, DataObject dataObject) {
		return new NamedDataObject(name, dataObject);
	}

}
