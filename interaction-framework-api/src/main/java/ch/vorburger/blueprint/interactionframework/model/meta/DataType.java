package ch.vorburger.blueprint.interactionframework.model.meta;

/**
 * AKA EMF DataType, etc.
 */
public interface DataType {

	/**
	 * Java class of this data type.
	 * 
	 * @return Java Type
	 */
	Class<?> getJavaClass();

}
