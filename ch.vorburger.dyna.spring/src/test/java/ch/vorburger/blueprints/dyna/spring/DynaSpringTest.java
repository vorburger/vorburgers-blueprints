package ch.vorburger.blueprints.dyna.spring;

import static org.junit.Assert.assertEquals;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public class DynaSpringTest {

	@Test
	public void testBeanWrapper() throws IllegalAccessException, InstantiationException {
		DynaClass dynaClass = new BasicDynaClass(
				"TestDynaClass", null, 
				new DynaProperty[] { new DynaProperty("name", String.class) });
		
		DynaBean dynaBean = dynaClass.newInstance();
		BeanWrapper bean = new BeanWrapperImpl(dynaBean);
		bean.setPropertyValue("name", "Michael");
		assertEquals("Michael", dynaBean.get("name"));
	}

	@Test
	public void testExpressionParser() throws IllegalAccessException, InstantiationException {
		DynaClass dynaClass = new BasicDynaClass(
				"TestDynaClass", null, 
				new DynaProperty[] { new DynaProperty("name", String.class) });

		DynaBean dynaBean = dynaClass.newInstance();
		dynaBean.set("name", "Michael");
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");
		String name = (String) exp.getValue(dynaBean);
		assertEquals("Michael", name);
	}

}
