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
	
	
}
