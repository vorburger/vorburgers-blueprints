package ch.vorburger.blueprint.interactionframework.model.repo.tests;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import ch.vorburger.blueprint.interactionframework.model.repo.FilterCriteriaExpression;
import ch.vorburger.blueprint.interactionframework.model.repo.FilterCriteriaExpression.FilterOperator;
import ch.vorburger.blueprint.interactionframework.model.repo.FilterAndOrExpression;
import ch.vorburger.blueprint.interactionframework.model.repo.FilterLiteralTerm;
import ch.vorburger.blueprint.interactionframework.model.repo.FilterNotExpression;
import ch.vorburger.blueprint.interactionframework.model.repo.FilterVariableTerm;

/**
 * Unit Test for the Filter API.
 * 
 * More of a usage example of the Filter API really - doesn't "test" much. 
 * 
 * @author Michael Vorburger
 */
public class FilterTest {

	@Test
	public void testFilters() {
		FilterCriteriaExpression criteria1 = new FilterCriteriaExpression();
		criteria1.lhs = new FilterVariableTerm("a");
		criteria1.rhs = new FilterLiteralTerm<String>("Hello World");

		FilterCriteriaExpression criteria2 = new FilterCriteriaExpression("b.x",
				FilterCriteriaExpression.FilterOperator.GREATER_THAN, 12);
		FilterNotExpression notCriteria2 = new FilterNotExpression(criteria2);

		FilterAndOrExpression criteria1OrCriteria2 = new FilterAndOrExpression();
		criteria1OrCriteria2.lhs = criteria1;
		criteria1OrCriteria2.operator = FilterAndOrExpression.FilterOperator.OR;
		criteria1OrCriteria2.rhs = notCriteria2;
	}

	@Test
	public void testNullFilter() {
		FilterCriteriaExpression criteria = new FilterCriteriaExpression();
		criteria.lhs = new FilterVariableTerm("a");
		criteria.rhs = new FilterLiteralTerm<Object>(null);
	}

	@Test
	public void testInFilter() {
		FilterCriteriaExpression criteria = new FilterCriteriaExpression();
		criteria.lhs = new FilterVariableTerm("a");
		criteria.operator = FilterOperator.IN;
		Collection<Integer> inCollection = new HashSet<Integer>();
		inCollection.add(1);
		inCollection.add(2);
		inCollection.add(3);
		criteria.rhs = new FilterLiteralTerm<Collection<Integer>>(inCollection);
	}

}
