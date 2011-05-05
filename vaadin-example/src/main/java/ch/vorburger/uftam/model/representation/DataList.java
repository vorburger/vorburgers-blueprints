package ch.vorburger.uftam.model.representation;

/**
 * TODO Doc
 * 
 * One instance of this class represents a "slide", or "current page", of a larger list.
 * 
 * @author Michael Vorburger (MVO)
 */
public interface DataList<T> extends Representation {
	// TODO remove & replace with new Resources.page() infra!

	DataList<T> getMore(DataListRequest<T> req);

	/**
	 * Count.
	 * 
	 * @return Total number of elements - not just current "page".
	 */
	long count();
}
