package ch.vorburger.blueprint.interactionframework.model.meta;

// Not currently used
interface MetaFactory {
	// TODO Better API: New EntityType on EntityMetadata, new PropertyType on DataStructType, etc.
	
	EntityMetadata newEntityMetadata();
	
	EntityType newEntityType();
	
	DataStructType newDataStructType();
	
	DataType newDataType(Class<?> javaClass);
	
	PropertyType newPropertyType();

}
