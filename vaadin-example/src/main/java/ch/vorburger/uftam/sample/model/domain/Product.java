package ch.vorburger.uftam.sample.model.domain;

// TODO Not used yet...
public class Product {

	public String name;
	public double price;
	
	public boolean availableInStock;
	public boolean active;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailableInStock() {
		return availableInStock;
	}
	public void setAvailableInStock(boolean availableInStock) {
		this.availableInStock = availableInStock;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
