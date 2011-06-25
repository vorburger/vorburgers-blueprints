package ch.vorburger.blueprint.interactionframework.model.repo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class EntityRepositoryQuery implements Serializable {
	// no kinda execute() here - this is (remoteable) data describing the Query only

	public int startPosition;  // intentionally public

	public int maxResults;
	
	public final List<OrderBy> ordering = new LinkedList<OrderBy>();

	public FilterExpression filter;
	
	
	// And just for convenience for die-hard getter/setter fans:
	public EntityRepositoryQuery setStartPosition(int startPosition) {
		this.startPosition = startPosition;
		return this;
	}
	public int getStartPosition() {
		return this.startPosition;
	}
	
	public EntityRepositoryQuery setMaxResults(int maxResults) {
		this.maxResults = maxResults;
		return this;
	}
	public int getMaxResults() {
		return maxResults;
	}
	
	public List<OrderBy> getOrdering() {
		return this.ordering;
	}
}
