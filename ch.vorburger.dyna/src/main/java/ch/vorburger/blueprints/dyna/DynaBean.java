package ch.vorburger.blueprints.dyna;

/**
 * Bean with Properties.
 * 
 * It's a Map<String, Object> really, but with clear signatures & name.
 * 
 * Intentionally no "Type" at all here - that's not the point. 
 * 
 * Property Names are just Names - not Paths.
 * 
 * @author Michael Vorburger
 */
public interface DynaBean {

	Object get(String propertyName) throws IllegalArgumentException;

	void set(String propertyNamePath, Object value) throws IllegalArgumentException;

}
