package ch.vorburger.blueprint.disrest.core;

/**
 * Collection of Resources.
 * 
 * In a REST XML representation, this may be represented by e.g. an Atom Feed.
 * 
 * @author Michael Vorburger
 */
public interface Resources<E extends Resource> {
	// TODO could make this extends Resource, sensible e.g. for bulk delete() ?! hm, not sure, may
	// be later.

	// TODO Property<E> get(T_ID or just String id); - here or in Resources?

	/**
	 * Creates a new Resource in this collection. The returned instance may be completely empty, or
	 * already somewhat pre-initialized.
	 */
	E create();

	/**
	 * Count number of Resources in this Resource Collection.
	 * 
	 * @return size, or Long.MAX_VALUE if unknown; 0 if empty (no Elements)
	 */
	long size();

//	/**
//	 * Get to the data, in a paged fashion (only). The sort order is some kind of back-end
//	 * determined default sort order.
//	 * 
//	 * @param pageSize how many items to return
//	 * 
//	 * @return a Page
//	 */
//	ResourcesPage<E> page(int pageSize);

	/**
	 * Like above, but specify starting page number.
	 * 
	 * @param startPageNumber page starting with 1 (0 or negative numbers not allowed)
	 */
	ResourcesPage<E> page(long startPageNumber, int pageSize);
	// TODO ResourcesPage<E> page(long pageNumber, int pageSize, SortOrder orderedBy);
	// TODO SortOrder newOrderBy();

	// TODO ResourcesFilter<E> filter();
}
