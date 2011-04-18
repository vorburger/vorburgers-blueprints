package ch.vorburger.uftam.sample.model.domain.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ch.vorburger.uftam.sample.model.domain.Customer;
import ch.vorburger.uftam.sample.model.domain.LineItem;
import ch.vorburger.uftam.sample.model.domain.Order;

import com.google.common.collect.Sets;

public class CustomersRepository {

	// TODO Paging, via DataService! Boo... ;-)
	static public Collection<Customer> getAllCustomers() {
		Iterable<Customer> it = customerIterable();
		Set<Customer> s = Sets.newLinkedHashSet(it); // TODO not sure this is smart? No idea now, just demo anyway..
		return s;
	}

	public static Collection<Customer> getAFewCustomers() {
		List<Customer> list = new ArrayList<Customer>(10);
		Iterable<Customer> iterable = customerIterable();
		Iterator<Customer> iterator = iterable.iterator();
		for (int i = 0; i < 100; i++) {
			list.add(iterator.next());
		}
		return list;
	}
	
	private static Iterable<Customer> customerIterable() {
		Iterable<Customer> it = new Iterable<Customer>() {
			@Override
			public Iterator<Customer> iterator() {
				return new Iterator<Customer>() {

					long i = 1;
					
					@Override
					public boolean hasNext() {
						return true;
					}

					@Override
					public Customer next() {
						Customer customer = new Customer();
						customer.id = i;
						customer.name = "Customer " + i++;
						customer.getOrders().addAll(newOrders(customer));
						return customer;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
		return it;
	}
	
	static private Collection<Order> newOrders(Customer customer) {
		Collection<Order> orders = new LinkedList<Order>();
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.customer = customer;
			order.date = new Date();
			order.rebate = 0.5;
			order.notes = "Hurry up, it's for Christmas!";
			order.items = newLineItems(); 
			orders.add(order);
		}
		return orders;
	}

	private static List<LineItem> newLineItems() {
		ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
		for (int i = 0; i < 10; i++) {
			LineItem item = new LineItem();
			item.name = "Item " + i;
			lineItems.add(item);
		}
		return lineItems;
	}

}
