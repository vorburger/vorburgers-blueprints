package ch.vorburger.blueprints.sample.form.vaadin;

public class SomeBeanServiceImpl implements SomeBeanService {

	@Override
	public SomeBean get(long id) {
		return new SomeBean("Michael", 123.45);
	}

	@Override
	public SomeBean update(SomeBean someBean) {
		System.out.println(someBean.amount);
		if (someBean.amount == 123.0) {
			someBean.name = "Hello World!";
		} else {
			someBean.amount = someBean.amount + 1;
		}
		return someBean;
	}

}
