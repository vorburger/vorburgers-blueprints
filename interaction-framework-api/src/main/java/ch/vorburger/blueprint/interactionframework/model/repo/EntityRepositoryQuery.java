package ch.vorburger.blueprint.interactionframework.model.repo;

import java.util.List;

/**
 * TODO Doc
 *
 * @author Michael Vorburger & Kai Kreuzer
 */
public interface EntityRepositoryQuery {
	// no kinda execute() here - data describing the Query only
	
	void setStartPosition(int startPosition);
	
	void setMaxResults(int maxResults);
	
	List<OrderBy> getOrdering();
}
