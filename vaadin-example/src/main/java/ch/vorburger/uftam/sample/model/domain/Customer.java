package ch.vorburger.uftam.sample.model.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	public long id;
	public String name;
	private Set<Order> orders = new HashSet<Order>(); // inverse of Order.customer

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// TODO Paging, scalability...
	public Set<Order> getOrders() {
		return orders;
	}

	// TODO country & states
}
