package ch.vorburger.blueprint.interactionframework.model;

import java.io.Serializable;

import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.resources.Resource;

/**
 * Dynamic bean.
 * AKA Data Transfer Object, etc.
 *
 * This does NOT have an Identity (no ID field),
 * and is not (necessarily) "externally addressable" - as opposed to an {@link Entity} or a {@link Resource}.
 *
 * @see org.eclipse.emf.ecore.EObject
 * @see com.vaadin.data.Item
 * @see http://commons.apache.org/beanutils/api/org/apache/commons/beanutils/DynaBean.html
 * @see org.odata4j.producer.inmemory.PropertyModel
 * @see org.springframework.data.mapping.model.PersistentEntity
 * @see javax.persistence.metamodel.EntityType
 * 
 * @author Michael Vorburger
 */
public interface DataStruct extends Serializable {
	// TODO Rename... I'm not entirely happy naming this an Entity, because this can be sub-entity
	// which doesn't have an ID, while in JPA an Entity is explicitly something with an ID, the
	// others are just embedded beans.  How about... "DataObject" ?!

	Property<?> getProperty(String name);
	// TODO Object getPropertyValue(String name), 

	Property<?> getProperty(PropertyType propertyType);

	// TODO Property<?> getProperty(PropertyPath propertyPath);
	
	// TODO References/Links, how-to? Or just properties?!


	DataStructType getDataStructType();
}
