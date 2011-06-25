package ch.vorburger.blueprint.interactionframework.model.meta;

public interface MetaFactory {

	DataStructType newDataStructType();
	
	DataType newDataType();
	
	EntityType newEntityType();
	
	PropertyType newPropertyType();
}
