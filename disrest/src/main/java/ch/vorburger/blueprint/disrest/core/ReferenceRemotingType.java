package ch.vorburger.blueprint.disrest.core;

/**
 * Enum to specify remoting type for references.
 * 
 * This expresses whether upon serialization the full target (the linked-to Resource) of a reference
 * property is "embedded" in a Resource, or only some kind of lightweight location / pointer to it
 * goes on the wire.
 * 
 * This is "by design" intentionally not part of the Resource (Java) API, from a using client's
 * local perspective. The idea is allowing an API user to avoid dealing explicitly with "IDs" and
 * "Repositories" (where to look-up stuff, given an ID) etc. A (Java) client using Resources of a
 * given Interaction Model does not have to actually know about the ReferenceRemotingType among
 * Resource references.
 * 
 * Conceptually this is a similar idea to e.g. EMF's ResolveProxy StructuralFeature control flag, or
 * JPA's Lazy vs. Eacher FetchType.
 * 
 * Note that the ReferenceRemotingType of Resource references is not per-se related to the modeling
 * concept of "containment" (i.e. UML association vs. aggregation & composition) in the underlying
 * data model. For example, while e.g. a Book & Authors relationship in the underlying data model
 * probably is a (typically bi-directional) association and not an aggregation or composition, some
 * Resource models may expose relations to Books or Authors as ONLY_REFERENCE and some others as
 * EMBED.
 * 
 * @author Michael Vorburger
 */
public enum ReferenceRemotingType {

	/**
	 * Transmit only some kind of @Id for Remoting.
	 */
	ONLY_REFERENCE,

	/**
	 * Embed the entire referenced Resource in the 'parent' resource. For multiplicity many
	 * references, this is typically not a good idea if there are many elements in the collection.
	 */
	EMBED,

// TODO EMBED_SOME
//	/**
//	 * Embed some (the first couple) but not all referenced Resource in the 'parent' resource. This
//	 * is only applicable for multiplicity many references; for single references it means the same
//	 * as EMBED.
//	 */
//	EMBED_SOME;
}
