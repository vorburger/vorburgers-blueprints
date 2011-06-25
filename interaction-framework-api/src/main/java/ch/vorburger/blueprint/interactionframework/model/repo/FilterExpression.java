package ch.vorburger.blueprint.interactionframework.model.repo;

public interface FilterExpression {

	@Override
	String toString();
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
}
