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
	
	public final FilterExpression lhs;
	public final FilterExpression rhs;
	
	public FilterAndOrExpression(FilterExpression criteria1, FilterExpression criteria2) {
		this.lhs = criteria1;
		this.rhs = criteria2;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(lhs.toString());
		
		if (operator == FilterOperator.AND)
			sb.append('+');
		else if (operator == FilterOperator.OR)
			throw new UnsupportedOperationException(); // TODO
		
		sb.append(rhs.toString());
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
		FilterAndOrExpression other = (FilterAndOrExpression) obj;
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
