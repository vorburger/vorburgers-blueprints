package ch.vorburger.blueprint.common.data.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import ch.vorburger.blueprint.common.data.DataStruct;
import ch.vorburger.blueprint.common.data.DataStructObject;
import ch.vorburger.blueprint.common.data.dyn.DynDataStruct;
import ch.vorburger.blueprint.common.data.dyn.DynDataStructObjectFactory;
import ch.vorburger.blueprint.common.data.statc.StaticDataStructObjectFactory;
import ch.vorburger.blueprint.common.data.test.statc.Customer;
import ch.vorburger.blueprint.common.data.test.statc.Order;

/**
 * Tests for DataStruct.
 * 
 * @author Michael Vorburger
 */
public class DataStructTest {

	@Test
	public void testDynDataStruct() {
		DynDataStruct orderStruct = new DynDataStruct("Order");
		orderStruct.newProperty("date").type(Date.class);

		DynDataStruct customerStruct = new DynDataStruct("Customer");
		customerStruct.newProperty("name").type(String.class);
		customerStruct.newProperty("orders").multiple().type(orderStruct);
		
		DataStructObject customer1 = DynDataStructObjectFactory.create(customerStruct);
		customer1.setPropertyValue("name", "First Customer");
		// TODO Hamcrest? assertThat(customer1.getProperty("name"), IsEqual("First Customer"));
		assertEquals("First Customer", customer1.getPropertyValue("name"));

		DataStructObject order11 = DynDataStructObjectFactory.create(orderStruct);
		order11.setPropertyValue("date", new Date(123456));
		customer1.addPropertyValue("orders", order11);
	}

	@Test
	public void testStaticDataStruct() {
		Customer customer1 = StaticDataStructObjectFactory.create(Customer.class, Customer.STRUCT);
		customer1.setName("First Customer");
		assertEquals("First Customer", customer1.getName());

		// Can also access like this, note how property type is still correctly statically typed!
		String name = customer1.getPropertyValue(Customer.name);
		assertEquals("First Customer", name);

		// Can even access like this:
		assertEquals("First Customer", customer1.getPropertyValue("name"));
		
		// NOTE how this won't compile, because the type is wrong: 
		// Integer number = customer1.getPropertyValue(Customer.name);

		// NOTE how this won't compile, because we're attempting to use a property of Order on Customer:
		// name = customer1.getPropertyValue(Order.name);
		
		// Of course other things works as above in the dyn as well:
		Order order11 = StaticDataStructObjectFactory.create(Order.class, Order.STRUCT);
		order11.setDate(new Date(123456));
		customer1.getOrders().add(order11);
	}

	
	// TODO
	@Test(expected = IllegalArgumentException.class)
	public void testDynDataStructWrongPropertyName() {
		DataStruct fooBar = new DynDataStruct("Foo");
		// Don't add any properties to this structure...
		DataStructObject foo = DynDataStructObjectFactory.create(fooBar);
		// should throw an Exception because this property (name) doesn't exist!
		foo.setPropertyValue("aosdinaovuawnev", null);
	}

	// TODO
	@Test(expected = IllegalArgumentException.class)
	public void testDynDataStructWrongPropertyType() {
		DynDataStruct fooBar = new DynDataStruct("Foo");
		fooBar.newProperty("something").type(String.class);
		DataStructObject foo = DynDataStructObjectFactory.create(fooBar);
		 // should throw an Exception because this property is a String and not a Number (Type Converters are elsewhere)
		foo.setPropertyValue("name", 123);
	}

	// TODO
	@Test(expected = IllegalArgumentException.class)
	public void testDynDataStructWrongPropertyNonMultiple() {
		DynDataStruct fooBar = new DynDataStruct("Foo");
		fooBar.newProperty("name").type(String.class);
		DataStructObject foo = DynDataStructObjectFactory.create(fooBar);
		 // should throw an Exception because this property is not multiple
		foo.addPropertyValue("name", "Hello World 1");
	}

}
