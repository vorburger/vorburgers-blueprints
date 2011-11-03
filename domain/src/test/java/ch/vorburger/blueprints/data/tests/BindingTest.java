package ch.vorburger.blueprints.data.tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.binding.SimpleBinding;
import ch.vorburger.blueprints.data.binding.BindingException;

/**
 * Tests for Binding.
 *
 * @author Michael Vorburger
 */
public class BindingTest {

	@Test
	public void testBinding() throws Exception {
		SimpleBinding b = new SimpleBinding();
		b.addMappingFromTo("a.something", "c.somethingElse");
		b.addMappingFromTo("b.somethingElse", "c.something");
		
		TestDataObject a_fromObject = new TestDataObject();
		a_fromObject.something = 27L;

		TestDataObject b_fromObject = new TestDataObject();
		b_fromObject.somethingElse = 113L;

		TestDataObject c_toObject = new TestDataObject();
		
		b.mapFromTo(SimpleBinding.newNamedDataObject("a", a_fromObject),
					SimpleBinding.newNamedDataObject("b", b_fromObject),
					SimpleBinding.newNamedDataObject("c", c_toObject));
		
		// a & b should not have changed:
		Assert.assertEquals(new Long(27), a_fromObject.something);
		Assert.assertEquals(null, a_fromObject.somethingElse);
		Assert.assertEquals(null, b_fromObject.something);
		Assert.assertEquals(new Long(113), b_fromObject.somethingElse);
		
		// c should have been mapped:
		Assert.assertEquals(new Long(113), c_toObject.something);
		Assert.assertEquals(new Long(27), c_toObject.somethingElse);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testBadBinding1() throws Exception {
		new SimpleBinding().addMappingFromTo("a.something", "c.");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBadBinding2() throws Exception {
		new SimpleBinding().addMappingFromTo("something", "c.somethingElse");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testBadBinding3() throws Exception {
		new SimpleBinding().addMappingFromTo("b.somethingElse", "something");
	}
	
	private static class TestDataObject implements DataObject {
		Long something;
		Long somethingElse;

		@Override
		public Object get(String path) throws IllegalArgumentException {
			if (path.equals("something")) {
				return something;
			} else if (path.equals("somethingElse")) {
				return somethingElse;
			}
			throw new UnsupportedOperationException(path);
		}

		@Override
		public void set(String path, Object value) throws IllegalArgumentException {
			if (path.equals("something")) {
				this.something = (Long) value;
			} else if (path.equals("somethingElse")) {
				this.somethingElse = (Long) value;
			} else {
				throw new UnsupportedOperationException(path);
			}
		}

		@Override
		public <T> T get(String path, Class<T> type) throws IllegalArgumentException {
			throw new UnsupportedOperationException();
		}

	}
	
}
