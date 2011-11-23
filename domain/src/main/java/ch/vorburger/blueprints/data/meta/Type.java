package ch.vorburger.blueprints.data.meta;

import java.util.Collection;

/**
 * Type.
 *
 * @author Michael Vorburger
 */
public interface Type {

	/**
	 * Contrary to e.g. a SDO commonj.sdo.Type, or a Java Package + Name, this is a complete "fully qualified name".
	 *  
	 * @return URI
	 */
	String getURI();
	
	/**
	 * Properties.
	 * 
	 * Null if this is a leaf/simple type.
	 * Empty if this is a complex type which has no properties.
	 * 
	 * @return immutable read-only List of Properties
	 */
	// TODO No it really should be a List, not just a Collection.. (Order matters, sometimes)
	Collection<Property> getProperties();
	
	/**
	 * Convenience function to access a Property directly by name.
	 * 
	 * Null if this is a leaf/simple type.
	 */
	Property getProperty(String name);

	/**
	 * Java class of this type.
	 * 
	 * Only set if this is a leaf/simple type; null if this is a complex type. 
	 * 
	 * @return Java class
	 */
	Class<?> getInstanceClass();

	// TODO Should move getInstanceClass() from Type to Property, but change semantics (Doc): Type == null && InstanceClass != null is Leaf, Type != null && InstanceClass == null is Reference, Type == null && InstanceClass == null, or Type != null && InstanceClass != null, are not permitted
	// Then can also remove "Null if this is a leaf/simple type." from getProperties() abov, and dito from getProperty(String name)
	// But then Property Impl needs to have both a Class instanceClass AND a Type type field.. or a combined data structure, ClassOrType? 
	
	// Intentionally no boolean isInstance(Object object) kinda Op here
}
