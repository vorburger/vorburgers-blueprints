package ch.vorburger.blueprint.interactionframework.model.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import ch.vorburger.blueprint.interactionframework.model.DataStruct;
import ch.vorburger.blueprint.interactionframework.model.ModelFactory;
import ch.vorburger.blueprint.interactionframework.model.Property;
import ch.vorburger.blueprint.interactionframework.model.impl.simple.SimpleModelFactory;
import ch.vorburger.blueprint.interactionframework.model.meta.DataStructType;
import ch.vorburger.blueprint.interactionframework.model.meta.DataType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;


/**
 * Tests for the Simple Model Impl.
 * 
 * Uses mock meta implementations, not the meta.simple *Impl.
 *
 * @author Michael Vorburger
 */
public class ModelImplSimpleTest {

	static class TestDataType implements DataType {
		@Override
		public Class<?> getJavaClass() {
			return java.lang.String.class;
		}

		@Override
		public String getName() {
			return getClass().getName();
		}
	}
	static DataType testDataType = new TestDataType(); 
	
	static class TestPropertyType1 implements PropertyType {
		@Override
		public String getName() {
			return "name";
		}

		@Override
		public DataType getValueType() {
			return testDataType;
		}
	}
	static PropertyType testPropertyType1 = new TestPropertyType1(); 

	static class TestPropertyType2 implements PropertyType {
		@Override
		public String getName() {
			return "description";
		}

		@Override
		public DataType getValueType() {
			return testDataType;
		}
	}
	static PropertyType testPropertyType2 = new TestPropertyType1(); 

	static class TestDataStructType implements DataStructType {
		Map<String, PropertyType> propertyTypesMap = new HashMap<String, PropertyType>();
		
		TestDataStructType() {
			propertyTypesMap.put(testPropertyType1.getName(), testPropertyType1);
		}
		
		@Override
		public String getName() {
			return TestDataStructType.class.getName();
		}

		@Override
		public Map<String, PropertyType> getPropertyTypesMap() {
			return this.propertyTypesMap;
		}

		@Override
		public Class<?> getJavaClass() {
			return null; // Perfectly OK, see JavaDoc
		}
	}
	static DataStructType testDataStructType = new TestDataStructType(); 

	
	@Test
	public void testNewDataStructWithMockMeta() {
		ModelFactory factory = new SimpleModelFactory();
		DataStruct o = factory.newDataStruct(testDataStructType);
		
		// No, not  : assertThat(o.getDataStructType(), is(testDataStructType));

		// getProperty(PropertyType propertyType) Tests:
		Property<String> p = o.getProperty(testPropertyType1);
		assertThat(p.isAvailable(), is(true));

		assertThat(p.getValue(), is(nullValue()));

		p.setValue("hello, World");
		assertThat(p.getValue(), is("hello, World"));
		
		
		// getProperty(String name) Tests:
		Property<String> pByName = o.getProperty(testPropertyType1.getName());
		assertThat(pByName, is(equalTo(p)));
		
		// Set through the byName property, get through the typeType one from before
		pByName.setValue("Something else");
		assertThat(p.getValue(), is("Something else"));

		
		// getPropertyMap() Tests:
		Map<String, Property<?>> props = o.getPropertyMap();
		assertThat(props.size(), is(1));
		
		@SuppressWarnings("unchecked")
		Property<String> pFromMap = (Property<String>) props.get(testPropertyType1.getName());
		assertThat(pFromMap, is(equalTo(p)));
	}

	@Test
	@Ignore
	public void testNewDataStructReferences() {
		// Embedded Object
		
		// Reference to another Object, by ID
	}
	
	@Test
	@Ignore
	public void testNewDataStructErrorHandling() {
		// Get an invalid PropertyType belonging to another struct
		
		// Get an invalid (non-existant) Property by name
		
		// Set a Property Value of the wrong Java Type
	}

	@Test
	@Ignore
	public void testExtendDataStructAtRunTime() {
		ModelFactory factory = new SimpleModelFactory();
		DataStruct o = factory.newDataStruct(testDataStructType);
		Property<String> p = o.getProperty(testPropertyType1);
		p.setValue("hello, World");

		testDataStructType.getPropertyTypesMap().put(testPropertyType2.getName(), testPropertyType2);
		
		assertThat(p.getValue(), is("hello, World"));
	}

}
