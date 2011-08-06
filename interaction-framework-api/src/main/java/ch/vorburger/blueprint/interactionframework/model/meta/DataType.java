package ch.vorburger.blueprint.interactionframework.model.meta;

/**
 * AKA EMF DataType, etc.
 */
public interface DataType {

	String getName();
	// remove getName() from PropertyType & DataStructType!

	/**
	 * Java class of this data type. May return null if this DataType has no strongly typed Java
	 * Class Type equivalent. It is perfectly valid for a model data type to be purely "dynamic".
	 * In particular DataStructType's javaClass will often be null (unless there is a static
	 * interface for it), while a PropertyType's valueType dataType javaClass normally will
	 * not be null (because any Property will ultimately be stored as a 'real' Java type;
	 * unless it's an embedded object of DataStructType). 
	 * 
	 * @return Java Type, or null
	 */
	Class<?> getJavaClass();

	// TODO Validation Constraints and the like
	
}
