package ch.vorburger.blueprints.dyna.binding;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base class for Binding Implementations.
 *
 * @author Michael Vorburger
 */
public abstract class AbstractBinding implements Binding {

	protected static final char PATH_SEPARATOR = '.';

	@Override
	public abstract void mapFromTo(Map<String, Object> dataObjectNameMap) throws BindingException; 

	@Override
	public void mapFromTo(NamedDataObject... namedDataObjects) throws BindingException {
		Map<String, Object> dataObjectNameMap = new HashMap<String, Object>();
		for (NamedDataObject namedDataObject : namedDataObjects) {
			dataObjectNameMap.put(namedDataObject.name, namedDataObject.dataObject);
		}
		mapFromTo(dataObjectNameMap);
	}

	public static NamedDataObject newNamedDataObject(String name, Object dataObject) {
		return new NamedDataObject(name, dataObject);
	}

}
