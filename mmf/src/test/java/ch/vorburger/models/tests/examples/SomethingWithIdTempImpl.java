package ch.vorburger.models.tests.examples;


/**
 * Impl.
 *
 * @author Michael Vorburger
 */
public class SomethingWithIdTempImpl implements SomethingWithId {
	// TODO remove this when I have created the thing which creates bytecode from interfaces on the fly
	
	private long id1;
	private String id2;
	private String name;
	
	public SomethingId _id() {
		SomethingIdTempImpl id = new SomethingIdTempImpl();
		id.id1(id1).id2(id2);
		return id;
	}

	public long id1() {
		return id1;
	}

	public SomethingWithId id1(long id1) {
		this.id1 = id1;
		return this;
	}

	public String id2() {
		return id2;
	}

	public SomethingWithId id2(String id2) {
		this.id2 = id2;
		return this;
	}

	public String name() {
		return name;
	}

	public SomethingWithId name(String name) {
		this.name = name;
		return this;
	}

}
