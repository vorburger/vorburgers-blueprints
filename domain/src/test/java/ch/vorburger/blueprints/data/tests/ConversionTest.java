package ch.vorburger.blueprints.data.tests;

import static org.junit.Assert.assertTrue;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.ConvertUtilsBean2;
import org.junit.Ignore;
import org.junit.Test;

import ch.vorburger.blueprints.data.conversion.ConversionService;
import ch.vorburger.blueprints.data.conversion.Converter;
import ch.vorburger.blueprints.data.conversion.Converter2BeanUtilsConverterAdapter;
import ch.vorburger.blueprints.data.tests.ConversionTest.ABConverter;

/**
 * Tests for Conversion.
 *
 * @author Michael Vorburger
 */
public class ConversionTest {
	
	static class A {
	}
	
	static class B {
	}
	
	static class ABConverter implements Converter<A, B> {
		@Override
		public B convert(A source) {
			return new B();
		}

		@Override
		public Class<B> getTargetClass() {
			return B.class;
		}
	}

	static class ObjectBConverter implements Converter<Object, B> {
		@Override
		public B convert(Object source) {
			return new B();
		}

		@Override
		public Class<B> getTargetClass() {
			return B.class;
		}
	}

	@Test
	public void testConversion() {
		ConversionService conv = new ConversionService();
		conv.registerObjectConverter(new ObjectBConverter());
		conv.register(new ABConverter());
		
		B b1 = conv.convert(new A(), B.class);
		assertTrue(b1 instanceof B);
		
		B b2 = conv.convert(new ConversionTest(), B.class);
		assertTrue(b2 instanceof B);
	}

	@Test
	@Ignore("https://issues.apache.org/jira/browse/BEANUTILS-403")
	public void testConversionWithBeanUtils() {
		ObjectBConverter objectBConverter = new ObjectBConverter();
		org.apache.commons.beanutils.Converter beanUtilsObjectBConverter = new Converter2BeanUtilsConverterAdapter<Object, B>(objectBConverter);
		ConvertUtils.register(beanUtilsObjectBConverter, objectBConverter.getTargetClass());

		ABConverter aBConverter = new ABConverter();
		org.apache.commons.beanutils.Converter beanUtilsABConverter = new Converter2BeanUtilsConverterAdapter<A, B>(aBConverter);
		ConvertUtils.register(beanUtilsABConverter, aBConverter.getTargetClass());

		B b1 = (B) ConvertUtils.convert(new A(), B.class);
		assertTrue(b1 instanceof B);
		
		B b2 = (B) ConvertUtils.convert(new ConversionTest(), B.class);
		assertTrue(b2 instanceof B);
	}
	
}
