package ch.vorburger.blueprint.interactionframework.model.repo.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ch.vorburger.blueprint.interactionframework.model.repo.FilterAndOrExpression;
import ch.vorburger.blueprint.interactionframework.model.repo.FilterCriteriaExpression;
import ch.vorburger.blueprint.interactionframework.model.repo.FilterCriteriaExpression.FilterOperator;
import ch.vorburger.blueprint.interactionframework.model.repo.FilterExpression;
import ch.vorburger.blueprint.interactionframework.model.repo.FilterParser;

/**
 * Unit Test for the Filter Parser.
 * 
 * @author Michael Vorburger
 */
public class FilterParserTest {

	@Test
	public void testFilterParser() {
		FilterCriteriaExpression criteria1 = new FilterCriteriaExpression("a", FilterOperator.EQUALS, "Hello \"World\"");
		// TODO Note how the '12' albeit probably an Integer, is used as String literal for now... type conversion is for later...
		FilterCriteriaExpression criteria2 = new FilterCriteriaExpression("b.x", FilterOperator.EQUALS, "12");

		FilterAndOrExpression criteria1OrCriteria2 = new FilterAndOrExpression(criteria1, criteria2);
		
		String filterString = criteria1OrCriteria2.toString();
		assertNotNull(filterString);
		System.out.println(filterString);
		FilterExpression filterTree = FilterParser.parse(filterString);
		assertNotNull(filterTree);
		assertEquals(criteria1OrCriteria2, filterTree);
	}
}
