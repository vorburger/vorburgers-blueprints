package ch.vorburger.blueprint.interactionframework.model.repo;

import java.io.Serializable;

import ch.vorburger.blueprint.interactionframework.model.PropertyPath;

/**
 * Query Ordering information.
 * 
 * @author Michael Vorburger
 */
public class OrderBy implements Serializable {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordering == null) ? 0 : ordering.hashCode());
		result = prime * result + ((propertyPath == null) ? 0 : propertyPath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderBy other = (OrderBy) obj;
		if (ordering != other.ordering)
			return false;
		if (propertyPath == null) {
			if (other.propertyPath != null)
				return false;
		} else if (!propertyPath.equals(other.propertyPath))
			return false;
		return true;
	}

}
