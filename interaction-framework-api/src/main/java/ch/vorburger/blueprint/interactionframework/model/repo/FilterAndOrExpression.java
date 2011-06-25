package ch.vorburger.blueprint.interactionframework.model.repo;


/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class FilterAndOrExpression implements FilterExpression {

	public enum FilterOperator {
		AND, OR
	}

	public FilterOperator operator = FilterOperator.AND;
	
	public FilterExpression lhs;
	public FilterExpression rhs;
	
	@Override
	public String asString() {
		StringBuilder sb = new StringBuilder();
		sb.append(lhs.asString());
		
		if (operator == FilterOperator.AND)
			sb.append('+');
		else if (operator == FilterOperator.OR)
			throw new UnsupportedOperationException(); // TODO
		
		sb.append(rhs.asString());
		return sb.toString();
	}
	
}
