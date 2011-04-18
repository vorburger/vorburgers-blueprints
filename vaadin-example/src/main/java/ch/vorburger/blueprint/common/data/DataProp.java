package ch.vorburger.blueprint.common.data;

/**
 * Property of a Data Structure.
 * 
 * @author Michael Vorburger
 */
public interface DataProp {

	String name();

	DataType type();

	boolean isMultiple();

	/**
	 * Required? Note that even if false, more fine-grained validation rules may make a property
	 * required e.g. in function of other properties even if this return false.
	 * 
	 * @return true if this property is required.
	 */
	// TODO build an example illustrating how validation rules may make a property required e.g. in
	// function of other properties even if this return false.
	boolean isRequired();
}
