package ch.vorburger.blueprint.common.data.test.statc;

import java.util.Date;

import ch.vorburger.blueprint.common.data.statc.StaticDataProp;
import ch.vorburger.blueprint.common.data.statc.StaticDataStruct;

/**
 * Example / Test of a statically typed Data Structure.
 * 
 * @author Michael Vorburger
 */
public interface Order {
	// NOTE that we don't HAVE to extend DataStructObject - Customer does, this doesn't...
	StaticDataStruct<Order> STRUCT = new StaticDataStruct<Order>(Order.class);
	
	Date getDate();
	Order setDate(Date date);
	StaticDataProp<Order, Date> date = new StaticDataProp<Order, Date>(STRUCT, "date").type(Date.class);

	String getName();
	Order setName(String name);
	StaticDataProp<Order, String> name = new StaticDataProp<Order, String>(STRUCT, "name").type(String.class);
	
	// NOTE that we don't HAVE to have these date & name constants. 

}
