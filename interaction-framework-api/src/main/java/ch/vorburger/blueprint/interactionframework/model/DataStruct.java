package ch.vorburger.blueprint.interactionframework.model;

import java.io.Serializable;
import java.util.Map;

import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.resources.Resource;

/**
 * Dynamic bean. AKA Data Transfer Object, etc.
 * 
 * This does NOT have an Identity (no ID field), and is not (necessarily) "externally addressable" -
 * as opposed to an {@link Entity} or a {@link Resource}.
 * 
 * @see org.eclipse.emf.ecore.EObject
 * @see com.vaadin.data.Item
 * @see http://commons.apache.org/beanutils/api/org/apache/commons/beanutils/DynaBean.html
 * @see org.odata4j.producer.inmemory.PropertyModel
 * @see org.springframework.data.mapping.model.PersistentEntity
 * @see javax.persistence.metamodel.EntityType
 * @see JCR (TODO)
 * 
 * @author Michael Vorburger
 */
public interface DataStruct extends Serializable {
	// TODO Rename... how about... "DataObject" ?!

	<T> Property<T> getProperty(String name);
	<T> Property<T> getProperty(PropertyType propertyType);

	// TODO Object getPropertyValue(String name);
	// TODO DataStruct setPropertyValue(String name, Object newValue);

	// TODO Property<?> getProperty(PropertyPath propertyPath);

	Map<String, Property<?>> getPropertyMap();

	// TODO References/Links, how-to? Or just properties?!

	DataStructType getDataStructType();

	/**
	 * String representation of this object. Only intended for developer convenience when debugging.
	 * Typically is a concatenation of something like {Impl} & {DataStructType.name} and then the
	 * properties as a list of name/value pairs.
	 */
	@Override
	String toString();

	/*
	 * Must be overridden in implementation!
	 */
	@Override
	public int hashCode();

	/*
	 * Must be overridden in implementation!
	 */
	@Override
	public boolean equals(Object obj);

}
