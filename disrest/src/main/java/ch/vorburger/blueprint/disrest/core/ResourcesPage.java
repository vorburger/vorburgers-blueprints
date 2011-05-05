package ch.vorburger.blueprint.disrest.core;

import java.util.List;


/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface ResourcesPage<E> extends Iterable<E> {

	/*
	long pageNumber();
	int pageSize();
	Order orderedBy();
	*/
	
	List<E> asList();
}
