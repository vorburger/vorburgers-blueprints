package ch.vorburger.blueprint.interactionframework.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Access Path to nested Property.
 * 
 * This class is (intentionally) immutable.
 * 
 * @author Michael Vorburger
 */
public class PropertyPath {

	private static final String REGEX ="[A-Za-z0-9]+"; //alpha-numeric upper- & lower-case, nothing else
	private static final Pattern REGEX_PATTERN = Pattern.compile(REGEX);
	
	private final List<String> finalUnmodifiablePropertyNames;
	private final String propertyNamesString;
	
	public PropertyPath(String propertyPath) {
		if ( propertyPath == null )
			throw new NullPointerException("propertyPath == null");
		if ( propertyPath.trim().length() == 0)
			throw new IllegalArgumentException("propertyPath.trim().length() == 0");

		List<String> propertyNames = new LinkedList<String>();
		
		int fromIndex = 0;
		int indexOfDotSeparator = propertyPath.indexOf('.', fromIndex);
		while (indexOfDotSeparator > 0) {
			String subPropertyName = propertyPath.substring(fromIndex, indexOfDotSeparator);
			checkSubPropertyNameAndAdd(propertyNames, subPropertyName, propertyPath);
			fromIndex = indexOfDotSeparator + 1; 
			indexOfDotSeparator = propertyPath.indexOf('.', indexOfDotSeparator + 1);
		}
		// Now add the last remaining segment
		String subPropertyName = propertyPath.substring(fromIndex);
		checkSubPropertyNameAndAdd(propertyNames, subPropertyName, propertyPath);
		
	    this.finalUnmodifiablePropertyNames = Collections.unmodifiableList(propertyNames);
	    this.propertyNamesString = propertyPath;
	}
	
	
	private void checkSubPropertyNameAndAdd(List<String> propertyNames, String subPropertyName, String propertyPath) {
		if (!REGEX_PATTERN.matcher(subPropertyName).matches()) {
			throw new IllegalArgumentException("Illegal Characters in sub-property name '" + subPropertyName + "' of path " + propertyPath);
		}
		propertyNames.add(subPropertyName);
	}


	/**
	 * Returns an (unmodifiable) list of properties.
	 */
	public List<String> getPropertyNames() {
		return finalUnmodifiablePropertyNames;
	}

	@Override
	public String toString() {
		return propertyNamesString;
	}
	
}
