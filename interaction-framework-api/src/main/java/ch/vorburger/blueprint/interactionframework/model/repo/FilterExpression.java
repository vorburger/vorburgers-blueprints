package ch.vorburger.blueprint.interactionframework.model.repo;

public interface FilterExpression {

	String asString();
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
}
