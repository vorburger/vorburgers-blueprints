package ch.vorburger.blueprint.interactionframework.model.repo;

import ch.vorburger.blueprint.interactionframework.model.PropertyPath;

/**
 * Query Ordering information.
 * 
 * @author Michael Vorburger
 */
public class OrderBy {
	enum Ordering {
		ASCENDING, DESCENDING
	};

	public Ordering ordering = Ordering.ASCENDING;

	public PropertyPath propertyPath;

	public Ordering getOrdering() {
		return ordering;
	}

	public OrderBy setOrdering(Ordering ordering) {
		this.ordering = ordering;
		return this;
	}

	public OrderBy setPropertyPath(PropertyPath propertyPath) {
		this.propertyPath = propertyPath;
		return this;
	}

	/**
	 * Switch the ordering.
	 */
	public void reverse() {
		if (ordering == Ordering.ASCENDING)
			ordering = Ordering.DESCENDING;
		else if (ordering == Ordering.DESCENDING)
			ordering = Ordering.ASCENDING;
	}

}
