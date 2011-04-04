package ch.vorburger.appviewsnflows.utils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import ch.vorburger.appviewsnflows.util.ReflectionUtil;


/**
 * Tests for ReflectionUtils.
 * 
 * @author Michael Vorburger
 */
public class ReflectionUtilsTest {

	@Test
	public void testFindConstructor() throws Exception {
		ArrayList<String> arg = new ArrayList<String>();
		arg.add("Hello");
		Constructor<TestClass> c = ReflectionUtil.findConstructor(TestClass.class, arg.getClass());
		TestClass o = c.newInstance(arg);
		Assert.assertEquals("Hello", o.getFirstString());
	}
}
