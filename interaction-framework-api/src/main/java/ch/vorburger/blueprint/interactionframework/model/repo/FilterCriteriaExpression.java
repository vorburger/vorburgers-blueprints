package ch.vorburger.blueprint.interactionframework.model.repo;



/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class FilterCriteriaExpression implements FilterExpression {

	public enum FilterOperator {
		EQUALS,
		// no NOT_EQUALS etc, use the FilterNotExpression around any Expression instead
		GREATER_THAN,
		SMALER_THAN,
		GREATER_EQUALS_THAN,
		SMALLER_EQUALS_THAN,
		IN
	}

	public FilterOperator operator = FilterOperator.EQUALS;
	
	public FilterTerm lhs;
	public FilterTerm rhs;
	
	public <T> FilterCriteriaExpression(String propertyPath, FilterOperator operator, T literal) {
		this.lhs = new FilterVariableTerm(propertyPath);
		this.operator = operator;
		this.rhs = new FilterLiteralTerm<T>(literal);
	}

	public FilterCriteriaExpression() {
	}

	@Override
	public String asString() {
		StringBuilder sb = new StringBuilder();
		sb.append(lhs.asString());
		
		if (operator == FilterOperator.EQUALS)
			sb.append('=');
		else
			throw new UnsupportedOperationException(operator.name()); // TODO
		
		sb.append(rhs.asString());
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((rhs == null) ? 0 : rhs.hashCode());
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
		FilterCriteriaExpression other = (FilterCriteriaExpression) obj;
		if (lhs == null) {
			if (other.lhs != null)
				return false;
		} else if (!lhs.equals(other.lhs))
			return false;
		if (operator != other.operator)
			return false;
		if (rhs == null) {
			if (other.rhs != null)
				return false;
		} else if (!rhs.equals(other.rhs))
			return false;
		return true;
	}

}
