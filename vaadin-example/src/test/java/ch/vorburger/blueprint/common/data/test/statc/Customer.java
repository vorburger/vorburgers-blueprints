package ch.vorburger.blueprint.common.data.test.statc;

import java.util.Collection;

import ch.vorburger.blueprint.common.data.statc.StaticDataProp;
import ch.vorburger.blueprint.common.data.statc.StaticDataStruct;
import ch.vorburger.blueprint.common.data.statc.StaticDataStructObject;

/**
 * Example / Test of a statically typed Data Structure.
 * 
 * @author Michael Vorburger
 */
public interface Customer extends StaticDataStructObject<Customer> {
	StaticDataStruct<Customer> STRUCT = new StaticDataStruct<Customer>(Customer.class);
	
	String getName();
	Customer setName(String name);
	StaticDataProp<Customer, String> name = new StaticDataProp<Customer, String>(STRUCT, "name").type(String.class);
	
	Collection<Order> getOrders();
	StaticDataProp<Customer, Collection<Order>> orders = new StaticDataProp<Customer, Collection<Order>>(STRUCT, "orders").multiple().type(Order.STRUCT);
	// NOTE that we don't HAVE to have an orders field constant - name does, this doesn't... 

}
