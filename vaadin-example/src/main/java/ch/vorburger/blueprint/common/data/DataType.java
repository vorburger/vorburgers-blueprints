package ch.vorburger.blueprint.common.data;

/**
 * Type of a Property of a Data Structure.
 * 
 * @author Michael Vorburger
 */
public interface DataType {

	String name();
	
	Class<?> javaType();
}
