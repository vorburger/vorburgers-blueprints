package ch.vorburger.blueprints.dyna.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

public class LearnSpringTest {

	@Test
	public void testBeanWrapper() {
		BeanWrapper company = new BeanWrapperImpl(new Company());
		company.setPropertyValue("name", "Some Company Inc.");
		PropertyValue value = new PropertyValue("name", "Some Company Inc.");
		company.setPropertyValue(value);

		BeanWrapper jim = new BeanWrapperImpl(new Employee());
		jim.setPropertyValue("name", "Jim Stravinsky");
		company.setPropertyValue("managingDirector", jim.getWrappedInstance());

		jim.setPropertyValue("salary", 123);
		Double salary = (Double) company.getPropertyValue("managingDirector.salary");
		assertTrue(123 == salary);
	}

	public class Company {
	    private String name;
	    private Employee managingDirector;

	    public String getName() {
	        return this.name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public Employee getManagingDirector() {
	        return this.managingDirector;
	    }
	    public void setManagingDirector(Employee managingDirector) {
	        this.managingDirector = managingDirector;
	    }
	}
	
	public class Employee {
	    private String name;
	    private double salary;

	    public String getName() {
	        return this.name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public double getSalary() {
	        return salary;
	    }
	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
	}
}
