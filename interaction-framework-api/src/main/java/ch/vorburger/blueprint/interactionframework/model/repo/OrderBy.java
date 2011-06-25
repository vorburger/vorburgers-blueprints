package ch.vorburger.blueprint.interactionframework.model.repo;

import ch.vorburger.blueprint.interactionframework.model.PropertyPath;


public interface OrderBy {
	enum Ordering { ASCENDING, DESCENDING };
	
	Ordering getOrdering();
	void setOrdering(Ordering ordering);
	
	void setPropertyPath(PropertyPath propertyPath);
}
