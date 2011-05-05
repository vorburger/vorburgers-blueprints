package ch.vorburger.blueprint.disrest.core;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface SingleReference<T extends Resource> extends Property<T> {
	// TODO keep or throw this and just use Property<Book> in Resources directly - what value does this add?!
}
