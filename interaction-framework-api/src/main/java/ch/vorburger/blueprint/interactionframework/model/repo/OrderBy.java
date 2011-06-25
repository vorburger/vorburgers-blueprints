package ch.vorburger.blueprint.interactionframework.model.repo;

import ch.vorburger.blueprint.interactionframework.model.PropertyPath;

/**
 * Query Ordering information.
 *
 * @author Michael Vorburger
 */
public class OrderBy {
	enum Ordering { ASCENDING, DESCENDING };
	
	public Ordering ordering = Ordering.ASCENDING;
	
	public PropertyPath propertyPath;
	
	Ordering getOrdering() {
		return ordering;
	}
	OrderBy setOrdering(Ordering ordering) {
		this.ordering = ordering;
		return this;
	}
	
	OrderBy setPropertyPath(PropertyPath propertyPath) {
		this.propertyPath = propertyPath;
		return this;
	}
}
