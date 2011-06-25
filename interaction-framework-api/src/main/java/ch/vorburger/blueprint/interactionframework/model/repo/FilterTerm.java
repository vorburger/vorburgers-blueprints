package ch.vorburger.blueprint.interactionframework.model.repo;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface FilterTerm {

	String asString();
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
}
