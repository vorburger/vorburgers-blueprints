package ch.vorburger.blueprint.interactionframework.model.meta;

//TODO Doc
public interface PropertyType /* TODO extends DataType */ {

	// TODO if it becomes IS-A instead of HAS-A then remove this:
	String getName();
	
	// TODO if it becomes IS-A instead of HAS-A then remove this:
	DataType getValueType();
	
	// TODO boolean isMultiple();
	
	// TODO EntityType getOwningEntity();
}
