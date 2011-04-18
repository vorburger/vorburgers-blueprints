package ch.vorburger.uftam.sample.model.domain;

import java.util.Date;
import java.util.List;

public class Order {

	public Date date;
	public String notes;
	public Customer customer; // inverse of Customer.orders
	public List<LineItem> items;
	public double rebate;

	// TODO status enum (OPEN, CLOSED)

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	public double getRebate() {
		return rebate;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
