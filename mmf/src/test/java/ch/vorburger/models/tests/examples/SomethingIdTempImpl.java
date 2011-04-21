package ch.vorburger.models.tests.examples;

/**
 * Impl.
 *
 * @author Michael Vorburger
 */
public class SomethingIdTempImpl implements SomethingId {
	// TODO remove this when I have created the thing which creates bytecode from interfaces on the fly

	private long id1;
	private String id2;

	public long id1() {
		return id1;
	}

	public SomethingId id1(long id1) {
		this.id1 = id1;
		return this;
	}

	public String id2() {
		return id2;
	}

	public SomethingId id2(String id2) {
		this.id2 = id2;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id1 ^ (id1 >>> 32));
		result = prime * result + ((id2 == null) ? 0 : id2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SomethingIdTempImpl other = (SomethingIdTempImpl) obj;
		if (id1 != other.id1)
			return false;
		if (id2 == null) {
			if (other.id2 != null)
				return false;
		} else if (!id2.equals(other.id2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SomethingId[id1=").append(id1).append(", id2=").append(id2).append("]");
		return builder.toString();
	}

}
