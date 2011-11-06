package ch.vorburger.blueprints.data.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.AbstractConverter;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Tests for Conversion.
 *
 * @see https://issues.apache.org/jira/browse/BEANUTILS-403
 * 
 * @author Michael Vorburger
 */
@SuppressWarnings("rawtypes")
public class ConversionBeanUtilsBugTest {
	
	static class A {
	}
	
	static class B {
		boolean flag;
		B(boolean flag) {
			this.flag = flag;
		}
	}
	
	static class ABConverter extends AbstractConverter {
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			if (!B.class.equals(type))
				throw new UnsupportedOperationException();
			return new B(false);
		}

		@Override
		protected Class getDefaultType() {
			return B.class;
		}
	}

	static class ObjectBConverter extends AbstractConverter {
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			if (!B.class.equals(type))
				throw new UnsupportedOperationException();
			return new B(true);
		}

		@Override
		protected Class getDefaultType() {
			return B.class;
		}
	}

	@Test
	@Ignore("https://issues.apache.org/jira/browse/BEANUTILS-403")
	public void testConversionWithBeanUtils() {
		Converter objectBConverter = new ObjectBConverter();
		ConvertUtils.register(objectBConverter, /* TODO Object.class, */ B.class);

		Converter aBConverter = new ABConverter();
		ConvertUtils.register(aBConverter, /* TODO A.class, */ B.class);

		B b1 = (B) ConvertUtils.convert(new A(), B.class);
		assertFalse(b1.flag);
		
		B b2 = (B) ConvertUtils.convert(new ConversionBeanUtilsBugTest(), B.class);
		assertTrue(b2.flag);
	}
	
}
