package ch.vorburger.blueprint.interactionframework.model.repo;

public class FilterLiteralTerm<T> implements FilterTerm {

	public T literal;

	public FilterLiteralTerm(T value) {
		this.literal = value;
	}

	@Override
	public String asString() {
		return literal.toString();
	}

}
