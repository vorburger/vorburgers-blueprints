package ch.vorburger.blueprint.disrest.core;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public interface ResourcesFilter<E extends Resource> {

	Resources<E> run(); // TODO better name?

	PropertyFilter<E> andProperty(String propertyName);

	public interface PropertyFilter<E extends Resource> {
		ResourcesFilter<E> isEqual(Object value);

		ResourcesFilter<E> isNotEqual(Object value);

		ResourcesFilter<E> contains(Object value);

		ResourcesFilter<E> doesNotContain(Object value);

		ResourcesFilter<E> isNull();

		ResourcesFilter<E> isNotNull();

		ResourcesFilter<E> lessThan(Object value);

		ResourcesFilter<E> greaterThan(Object value);

		ResourcesFilter<E> between(Object value1, Object value2);
	}
}
