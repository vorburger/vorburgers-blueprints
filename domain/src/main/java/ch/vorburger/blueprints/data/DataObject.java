package ch.vorburger.blueprints.data;

import java.io.Serializable;

/**
 * Data Object.
 * 
 * TODO Doc ... This is ... inspired by SDO but simpler... (simpler Path Expressions, no Change
 * Summary; open Types left to implementations ... double check with MMF Notes in older/first
 * round/project...
 * 
 * Path is either directly the name of a property in the Type of this DataObject
 * à la XPath, or SDO's "department.0/name", company.get("department[1]/name"), "department[number=123]", 
 * TODO Define if ".." & "/" should be supported.                
 * 
 * @author Michael Vorburger
 */
public interface DataObject extends Serializable {

	/**
	 * Short-form for {@link #get(String, Object.class)}.
	 */
	Object get(String path);

	/**
	 * 
	 * @param path Path (as defined above)
	 * @param type requested return Type
	 * @return value of the property
	 */
	<T> T get(String path, Class<T> type);

	/**
	 * Sets a property of either this object or an object reachable from it, as identified by the
	 * specified path, to the specified value.
	 * 
	 * @param path Path (as defined above)
	 * @param value Value of property
	 */
	void set(String path, Object value);

	
	// Don't need strongly-typed setters

	
	/** Returns whether a property of either this object or an object reachable from it, as identified by the specified path, is considered to be set. */
	// TODO Needed? boolean isSet(String path);
	
	/** Unsets a property of either this object or an object reachable from it, as identified by the specified path. */
	// TODO Needed? void unset(String path);

	/** Returns the containing data object or null if there is no container. */
	// TODO Needed? DataObject getContainer();

	/** Remove this object from its container and unset all its properties. */
	// TODO Needed? void delete();

	// Property property-based access could be added (Performance..), but let's see if there really is a need

	// int propertyIndex-based access won't be added - in case of JavaBean that makes no sense
	
	// Intentionally no Type getType() kinda Op here.. must be Serializable without pulling Types along!

}
