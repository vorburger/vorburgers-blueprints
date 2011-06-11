package ch.vorburger.blueprint.interactionframework.model;

import java.io.Serializable;

import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

/**
 * Dynamic bean.
 * AKA Data Transfer Object, etc.
 *
 * @see http://commons.apache.org/beanutils/api/org/apache/commons/beanutils/DynaBean.html
 * @see com.vaadin.data.Item
 * @see org.odata4j.producer.inmemory.PropertyModel
 * 
 * @author Michael Vorburger
 */
public interface Entity extends Serializable {
	// TODO Rename... I'm not entirely happy naming this an Entity, because this can be sub-entity
	// which doesn't have an ID, while in JPA an Entity is explicitly something with an ID, the
	// others are just embedded beans

	Property<?> getProperty(String name);

	Property<?> getProperty(PropertyType propertyType);

	// TODO References/Links, how-to? Or just properties?!

	EntityType getEntityType();

}
