package ch.vorburger.blueprints.data.meta;

/**
 * Property.
 * 
 * @author Michael Vorburger
 */
public interface Property {

	/**
	 * Returns the name of the property.
	 * @return Name of Property
	 */
	String getName();

	/**
	 * Returns the type of the property.
	 * @return Type of Property
	 */
	Type getType();

	/** Returns the containing type of this property. */
	// TODO If needed: Type getContainingType();
	
	// Intentionally no Object getDefault() 
}
