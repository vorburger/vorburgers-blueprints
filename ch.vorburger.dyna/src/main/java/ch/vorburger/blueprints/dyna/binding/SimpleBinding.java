package ch.vorburger.blueprints.dyna.binding;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ch.vorburger.blueprints.dyna.access.PropertyAccessorService;

/**
 * Simple Binding Implementation.
 * 
 * This is, intentionally, kept very simple;
 * i.e. expressions are not supported here, nor are any property type conversions. 
 * 
 * @author Michael Vorburger
 */
public class SimpleBinding extends AbstractBinding {

	private final PropertyAccessorService propertyAccessor;
	
	private List<SimpleMapping> mappings = new LinkedList<SimpleMapping>();
	
	public SimpleBinding(PropertyAccessorService propertyAccessor) {
		super();
		this.propertyAccessor = propertyAccessor;
	}

//	public Binding addFromType(String name, Type type) {
//		// TODO... store type, so we can do better checks on map() ...
//		return this;
//	}
//
//	public Binding addToType(String name, Type type) {
//		// TODO... store type, so we can do better checks on map() ...
//		return this;
//	}

	/**
	 * Add a Mapping.
	 * 
	 * @throws IllegalArgumentException if fromPath or toPath don't contain, or directly start with or end with a '.' dot
	 */
	public Binding addMappingFromTo(String fromPath, String toPath) {
		SimpleMapping mapping = new SimpleMapping();
		
		int fromPathIdx = fromPath.indexOf(PATH_SEPARATOR);
		if (fromPathIdx < 1 || fromPathIdx > fromPath.length() - 2) {
			throw new IllegalArgumentException("Bad fromPath: " + fromPath);
		}
		mapping.fromDataObjectName = fromPath.substring(0, fromPathIdx);
		mapping.fromPath = fromPath.substring(fromPathIdx + 1);

		int toPathIdx = toPath.indexOf(PATH_SEPARATOR);
		if (toPathIdx < 1 || toPathIdx > toPath.length() - 2) {
			throw new IllegalArgumentException("Bad in toPath: " + toPath);			
		}
		mapping.toDataObjectName = toPath.substring(0, toPathIdx);
		mapping.toPath = toPath.substring(toPathIdx + 1);

		mappings.add(mapping);
		return this;
	}

	@Override
	public void mapFromTo(Map<String, Object> dataObjectNameMap) throws BindingException {
		for (SimpleMapping mapping : mappings) {
			Object fromDO = dataObjectNameMap.get(mapping.fromDataObjectName);
			if (fromDO == null) 
				throw new BindingException("No DataObject named '" + mapping.fromDataObjectName + "' available for mapping " + mapping.toString());

			Object toDO = dataObjectNameMap.get(mapping.toDataObjectName);
			if (toDO == null) 
				throw new BindingException("No DataObject named '" + mapping.toDataObjectName + "' available for mapping " + mapping.toString());
			
			Object value = propertyAccessor.getPropertyValue(fromDO, mapping.fromPath);
			propertyAccessor.setPropertyValue(toDO, mapping.toPath, value);
		}
	}

	private static class SimpleMapping {
		String fromDataObjectName;
		String fromPath;
		String toDataObjectName;
		String toPath;
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(fromDataObjectName).append(PATH_SEPARATOR).append(fromPath);
			builder.append(" -> ");
			builder.append(toDataObjectName).append(PATH_SEPARATOR).append(toPath);
			return builder.toString();
		}
	}
	
}
