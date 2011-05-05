package ch.vorburger.blueprint.disrest.core;

import java.io.Serializable;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface Property<T> extends Serializable {

	// TODO Use Scala-like Option pattern instad? (Java-ified via Iterable like in playframework?)

	/**
	 * Getter to obtain the Property's value.
	 * 
	 * @throws PropertyValueUnavailableException if this property not {@link #isAvailable()}
	 * @return value, or null (if the property has no value, but is available)
	 */
	T value() throws PropertyValueUnavailableException;

	/**
	 * Is this property actually available? It may not (currently or anymore) be, for reasons
	 * including e.g. access control security (to the the current user), or schema evolution, etc.
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
	void value(T newValue) throws PropertyValueUnchangeableException;

	boolean isChangeable();

	
	// ---
	
	
	public class PropertyValueUnavailableException extends Exception {

		/**
		 * Constructs a new <code>PropertyValueUnavailableException</code> with the specified detail message.
		 * 
		 * @param msg the detail message
		 */
		public PropertyValueUnavailableException(String msg) {
			super(msg);
		}
	}

	public class PropertyValueUnchangeableException extends Exception {

		/**
		 * Constructs a new <code>PropertyValueUnchangeableException</code> with the specified detail message.
		 * 
		 * @param msg the detail message
		 */
		public PropertyValueUnchangeableException(String msg) {
			super(msg);
		}
	}
}
