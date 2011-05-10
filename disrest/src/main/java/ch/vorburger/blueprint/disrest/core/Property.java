package ch.vorburger.blueprint.disrest.core;

import java.io.Serializable;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface Property<T> extends Serializable {

	// TODO Use Scala-like Option pattern instad? (Java-ified via Iterable like in playframework?)

	// TODO could have method here to access the "structural feature", the "property descriptor" (from where you could get e.g. its name and further metadata)
	
	/**
	 * Getter to obtain the Property's value.
	 * 
	 * @throws PropertyValueUnavailableException if this property not {@link #isAvailable()}
	 * @return value, or null (if the property has no value, but is available)
	 */
	T get() throws PropertyValueUnavailableException;

	/**
	 * Is this property actually available? It may not (currently or anymore) be, for reasons
	 * including e.g. access control security (to the the current user), or schema evolution (if
	 * e.g. a statically typed interface still exposes a property from a previous meta model
	 * version, which has since been removed), etc.
	 * 
	 * In an e.g. XML marshaled instance, a non-available property may not even be part of (some of) the wire-level serialization. 
	 * 
	 * Note that the 'null' value and availability are distinct concepts.
	 * 
	 * @return true is this property is really available and value() is allowed, false if not
	 */
	boolean isAvailable();

	/**
	 * Setter to change the Property's value.
	 * 
	 * @param newValue the new value
	 */
	void set(T newValue) throws PropertyValueUnchangeableException;

	/**
	 * Can this property actually be changed? It may not (currently or never) be, for reasons
	 * including ready-only or access control security (to the the current user), or schema
	 * evolution (if it's a property still existing in an instance from a previous meta model
	 * version, which has since been removed), etc.
	 */
	boolean isChangeable();

	// ---

	public class PropertyValueUnavailableException extends Exception {
		private static final long serialVersionUID = -5564665540818979297L;

		/**
		 * Constructs a new <code>PropertyValueUnavailableException</code> with the specified detail
		 * message.
		 * 
		 * @param msg the detail message
		 */
		public PropertyValueUnavailableException(String msg) {
			super(msg);
		}
	}

	public class PropertyValueUnchangeableException extends Exception {
		private static final long serialVersionUID = 5676102879040503192L;

		/**
		 * Constructs a new <code>PropertyValueUnchangeableException</code> with the specified
		 * detail message.
		 * 
		 * @param msg the detail message
		 */
		public PropertyValueUnchangeableException(String msg) {
			super(msg);
		}
	}
}
