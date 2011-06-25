package ch.vorburger.blueprint.interactionframework.model.repo;

public class FilterLiteralTerm<T> implements FilterTerm {

	public T literal;

	public FilterLiteralTerm(T value) {
		this.literal = value;
	}

	@Override
	public String asString() {
		StringBuilder sb = new StringBuilder();
		sb.append('"');
		sb.append(literal.toString().replace("\"", "\\\""));
		sb.append('"');
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((literal == null) ? 0 : literal.hashCode());
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
		@SuppressWarnings("unchecked")
		FilterLiteralTerm<T> other = (FilterLiteralTerm<T>) obj;
		if (literal == null) {
			if (other.literal != null)
				return false;
		} else if (!literal.equals(other.literal))
			return false;
		return true;
	}

}
