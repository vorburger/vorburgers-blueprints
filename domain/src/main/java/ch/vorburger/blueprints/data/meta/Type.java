package ch.vorburger.blueprints.data.meta;

import java.util.List;

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
	List<Property> getProperties();
	
	/**
	 * Convenience function to access a Property directly by name.
	 */
	// TODO if really needed: Property getProperty(String propertyName); 

	/**
	 * Java class of this type.
	 * 
	 * Only set if this is a leaf/simple type; null if this is a complex type. 
	 * 
	 * @return Java class
	 */
	Class<?> getInstanceClass();
	
	// Intentionally no boolean isInstance(Object object) kinda Op here
}
