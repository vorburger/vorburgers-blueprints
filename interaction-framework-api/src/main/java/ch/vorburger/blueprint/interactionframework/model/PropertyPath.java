package ch.vorburger.blueprint.interactionframework.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Access Path to a (possibly nested) Property.
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
	
	/**
	 * Constructor.
	 * @param propertyPath Path to properties, '.' (dot) separated (or no dot)
	 */
	public PropertyPath(String propertyPath) {
		if (propertyPath == null )
			throw new NullPointerException("propertyPath == null");
		if (propertyPath.trim().length() == 0)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((finalUnmodifiablePropertyNames == null) ? 0 : finalUnmodifiablePropertyNames.hashCode());
		result = prime * result + ((propertyNamesString == null) ? 0 : propertyNamesString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyPath other = (PropertyPath) obj;
		if (finalUnmodifiablePropertyNames == null) {
			if (other.finalUnmodifiablePropertyNames != null)
				return false;
		} else if (!finalUnmodifiablePropertyNames.equals(other.finalUnmodifiablePropertyNames))
			return false;
		if (propertyNamesString == null) {
			if (other.propertyNamesString != null)
				return false;
		} else if (!propertyNamesString.equals(other.propertyNamesString))
			return false;
		return true;
	}
	
}
