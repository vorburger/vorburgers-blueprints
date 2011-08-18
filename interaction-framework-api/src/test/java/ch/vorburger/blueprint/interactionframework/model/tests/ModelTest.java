package ch.vorburger.blueprint.interactionframework.model.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.ModelFactory;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.SimpleModelFactory;
import ch.vorburger.blueprint.interactionframework.model.meta.DataType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;
import ch.vorburger.blueprint.interactionframework.model.meta.simple.DataTypeImpl;
import ch.vorburger.blueprint.interactionframework.model.meta.simple.EntityTypeImpl;


/**
 * Tests for the Simple Model Impl.
 * 
 * Uses meta.simple *Impl providers.
 *
 * @author Michael Vorburger
 */
public class ModelTest {

	@Test
	public void testNewEntity() {
		DataType stringDataType = new DataTypeImpl(String.class);
		EntityTypeImpl testEntityType = new EntityTypeImpl("SomeEntityType");

		testEntityType.addPropertyType("id1", stringDataType);  // TODO addIdPropertyType
		testEntityType.addPropertyType("id2", stringDataType);  // TODO addIdPropertyType

		PropertyType testPropertyTypeName = testEntityType.addPropertyType("name", stringDataType);
		assertTrue(testEntityType.getPropertyTypesMap().get("name") == testPropertyTypeName);
		
		ModelFactory factory = new SimpleModelFactory();
		DataStruct o = factory.newDataStruct(testEntityType);
		
		// No, not  : assertThat(o.getDataStructType(), is(testDataStructType));

		// getProperty(PropertyType propertyType) Tests:
		Property<String> p = o.getProperty(testPropertyTypeName);
		assertThat(p.isAvailable(), is(true));

		assertThat(p.getValue(), is(nullValue()));

		p.setValue("hello, World");
		assertThat(p.getValue(), is("hello, World"));
		
		
		// getProperty(String name) Tests:
		Property<String> pByName = o.getProperty(testPropertyTypeName.getName());
		assertThat(pByName, is(equalTo(p)));
		
		// Set through the byName property, get through the typeType one from before
		pByName.setValue("Something else");
		assertThat(p.getValue(), is("Something else"));

		
		// getPropertyMap() Tests:
		Map<String, Property<?>> props = o.getPropertyMap();
		assertThat(props.size(), is(3));
		
		@SuppressWarnings("unchecked")
		Property<String> pFromMap = (Property<String>) props.get(testPropertyTypeName.getName());
		assertThat(pFromMap, is(equalTo(p)));
	}
}
