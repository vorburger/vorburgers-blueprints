package ch.vorburger.blueprint.interactionframework.model.repo;

import java.io.Serializable;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface FilterTerm extends Serializable {

	@Override
	String toString();
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
}
