package ch.vorburger.blueprint.interactionframework.model.repo;

import ch.vorburger.blueprint.interactionframework.model.PropertyPath;

public class FilterVariableTerm implements FilterTerm {

	PropertyPath propertyPath;

	public FilterVariableTerm(String propertyPath) {
		super();
		this.propertyPath = new PropertyPath(propertyPath);
	}

	@Override
	public String asString() {
		return propertyPath.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		FilterVariableTerm other = (FilterVariableTerm) obj;
		if (propertyPath == null) {
			if (other.propertyPath != null)
				return false;
		} else if (!propertyPath.equals(other.propertyPath))
			return false;
		return true;
	}
	
}
