package ch.vorburger.blueprint.interactionframework.model.repo;

import ch.vorburger.blueprint.interactionframework.model.repo.FilterCriteriaExpression.FilterOperator;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public class FilterParser {

	// TODO @see org.odata4j.expression.ExpressionParser ... ;-)

	public static FilterExpression parse(String filterString) {
		Result r = nextCriteria(filterString, 0);
		FilterExpression expression = r.expression;
		while (r.position < filterString.length()) {
			r = nextCriteria(filterString, r.position + 1);
			expression = new FilterAndOrExpression(expression, r.expression);
		}
		return expression;
	}

	private static Result nextCriteria(String filterString, int fromIndex) {
		int indexOfNextEqualsSign = filterString.indexOf('=', fromIndex);
		assertChar(filterString, indexOfNextEqualsSign + 1, '"');

		String variablePath = filterString.substring(fromIndex, indexOfNextEqualsSign);

		int indexOfNextNonEscapedQuote = filterString.indexOf('\"', indexOfNextEqualsSign + 2);
		while (filterString.charAt(indexOfNextNonEscapedQuote - 1) == '\\') {
			indexOfNextNonEscapedQuote = filterString.indexOf('\"', indexOfNextNonEscapedQuote + 1);
		}

		String literal = filterString.substring(indexOfNextEqualsSign + 2, indexOfNextNonEscapedQuote);
		literal = literal.replace("\\\"", "\"");

		FilterCriteriaExpression expression = new FilterCriteriaExpression(variablePath, FilterOperator.EQUALS, literal);

		fromIndex = indexOfNextNonEscapedQuote + 1;
		if (fromIndex < filterString.length()) {
			assertChar(filterString, fromIndex, '+');
		}

		return new Result(expression, fromIndex);
	}

	private static class Result {
		FilterCriteriaExpression expression;
		int position;

		Result(FilterCriteriaExpression expression, int position) {
			this.expression = expression;
			this.position = position;
		}
	}

	private static void assertChar(String string, int pos, char expectedCharacter) {
		char charAtPos = string.charAt(pos);
		if (charAtPos != expectedCharacter) {
			throw new IllegalArgumentException("Expected character at position " + pos + " to be a '"
					+ expectedCharacter + "' but instead it's a " + charAtPos);
		}
	}

}
