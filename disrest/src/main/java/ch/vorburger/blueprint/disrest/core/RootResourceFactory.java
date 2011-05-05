package ch.vorburger.blueprint.disrest.core;


/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface RootResourceFactory<T> {

	/**
	 * Obtain the root node entry point into this interaction model.
	 * Think of this as "going to the 'home page'".
	 * 
	 * @return
	 */
	T home();

}
