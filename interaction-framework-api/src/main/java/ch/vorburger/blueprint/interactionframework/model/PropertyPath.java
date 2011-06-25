package ch.vorburger.blueprint.interactionframework.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Access Path to nested Property.
 *
 * @author Michael Vorburger
 */
public class PropertyPath {

	public final List<String> propertyNames = new LinkedList<String>();
	
	public PropertyPath(String propertyName) {
		propertyNames.add(propertyName);
	}
	
	public List<String> getPropertyNames() {
		return propertyNames;
	}
	
}
