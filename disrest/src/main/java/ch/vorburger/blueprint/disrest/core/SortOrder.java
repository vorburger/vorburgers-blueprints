package ch.vorburger.blueprint.disrest.core;

import java.io.Serializable;

/**
 * TODO Doc
 *
 * Inspired by Spring's org.springframework.data.domain.Sort
 *
 * @author Michael Vorburger
 */
public interface SortOrder extends Serializable {
	
	enum Direction {
		ASC, DESC;
	}
	
	/**
	 * Sorts by Direction ASC.
	 */
	SortOrder sortBy(String propertyName);
	
	SortOrder sortBy(String propertyName, Direction dir);
	
}
