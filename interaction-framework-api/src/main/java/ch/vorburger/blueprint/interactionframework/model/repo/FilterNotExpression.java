package ch.vorburger.blueprint.interactionframework.model.repo;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class FilterNotExpression implements FilterExpression {

	public FilterExpression negatedExpression;

	public FilterNotExpression(FilterCriteriaExpression negatedExpression) {
		this.negatedExpression = negatedExpression;
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((negatedExpression == null) ? 0 : negatedExpression.hashCode());
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
		FilterNotExpression other = (FilterNotExpression) obj;
		if (negatedExpression == null) {
			if (other.negatedExpression != null)
				return false;
		} else if (!negatedExpression.equals(other.negatedExpression))
			return false;
		return true;
	}

}
