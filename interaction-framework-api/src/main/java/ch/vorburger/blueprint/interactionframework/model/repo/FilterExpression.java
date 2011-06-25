package ch.vorburger.blueprint.interactionframework.model.repo;

import java.io.Serializable;

public interface FilterExpression extends Serializable {

	@Override
	String toString();
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
}
