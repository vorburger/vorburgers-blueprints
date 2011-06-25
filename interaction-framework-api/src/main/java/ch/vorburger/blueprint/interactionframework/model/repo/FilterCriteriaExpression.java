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

}
