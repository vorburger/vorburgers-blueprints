package ch.vorburger.blueprint.interactionframework.model;

/**
 * Idenfitier of an Entity.
 * 
 * Is itself a DataStruct, with Properties for (only) all of the EntityType's Identity Properties. 
 *
 * @author Michael Vorburger
 */
public interface EntityId extends DataStruct {

	// TODO Needed?  EntityType getEntityType();

	/**
	 * String-ified (externalizable) version of the ID of this object.
	 * 
	 * Only intended for debugging & convenience. The format as not specified, and may change.
	 * At present there is no Factory available to obtain EntityId instances from such Strings.
	 * 
	 * @return the Id as a String
	 */
	@Override
    String toString();

}
