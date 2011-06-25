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
	public String asString() {
		throw new UnsupportedOperationException(); // TODO
	}

}
