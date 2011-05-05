package ch.vorburger.blueprint.disrest.core;

import java.util.List;


/**
 * TODO Doc
 *
 * Implementations should pre-fetch the page size.
 * super.List.size() will will not return the page size,
 * but the entire Resources Collection size.  If more elements
 * than are currently loaded into the Page are accessed, the next
 * page is fetched transparently.
 *
 * @author Michael Vorburger
 */
public interface ResourcesPage<E> extends List<E> {
	
}
