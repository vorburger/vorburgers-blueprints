package ch.vorburger.blueprints.sample.form.vaadin;

public interface SomeBeanService {

	SomeBean get(long id);
	
	SomeBean update(SomeBean someBean);
	
}
