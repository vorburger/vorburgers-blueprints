package ch.vorburger.blueprints.dyna.tests;

import junit.framework.Assert;

import org.junit.Test;

import ch.vorburger.blueprints.dyna.DynaBean;
import ch.vorburger.blueprints.dyna.access.DynaBeanAwarePropertyAccessorService;
import ch.vorburger.blueprints.dyna.access.PathResolvingPropertyAccessorService;
import ch.vorburger.blueprints.dyna.access.PropertyAccessorService;
import ch.vorburger.blueprints.dyna.binding.SimpleBinding;

/**
 * Tests for Binding.
 *
 * @author Michael Vorburger
 */
public class BindingTest {

	@Test
	public void testSimpleBinding() throws Exception {
		PropertyAccessorService s = new DynaBeanAwarePropertyAccessorService(null);
		SimpleBinding b = new SimpleBinding(s);
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

	@Test
	public void testNestedBinding() throws Exception {
		PropertyAccessorService s = new DynaBeanAwarePropertyAccessorService(null);
		s = new PathResolvingPropertyAccessorService(s);
		SimpleBinding b = new SimpleBinding(s);
		b.addMappingFromTo("a.something", "c.containedObject.somethingElse");
		TestDataObject a_fromObject = new TestDataObject();
		a_fromObject.something = 27L;
		TestDataObject c_toObject = new TestDataObject();
		c_toObject.containedObject = new TestDataObject(); 
				
		b.mapFromTo(SimpleBinding.newNamedDataObject("a", a_fromObject),
					SimpleBinding.newNamedDataObject("c", c_toObject));
		
		Assert.assertEquals(new Long(27), c_toObject.containedObject.somethingElse);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBadBinding1() throws Exception {
		new SimpleBinding(null).addMappingFromTo("a.something", "c.");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBadBinding2() throws Exception {
		new SimpleBinding(null).addMappingFromTo("something", "c.somethingElse");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testBadBinding3() throws Exception {
		new SimpleBinding(null).addMappingFromTo("b.somethingElse", "something");
	}
	
	private static class TestDataObject implements DynaBean {
		Long something;
		Long somethingElse;
		TestDataObject containedObject;

		@Override
		public Object get(String path) throws IllegalArgumentException {
			if (path.equals("something")) {
				return something;
			} else if (path.equals("somethingElse")) {
				return somethingElse;
			} else if (path.equals("containedObject")) {
				return containedObject;
			}
			throw new UnsupportedOperationException(path);
		}

		@Override
		public void set(String path, Object value) throws IllegalArgumentException {
			if (path.equals("something")) {
				this.something = (Long) value;
			} else if (path.equals("somethingElse")) {
				this.somethingElse = (Long) value;
			} else if (path.equals("containedObject")) {
				this.containedObject = (TestDataObject) containedObject;
			} else {
				throw new UnsupportedOperationException(path);
			}
		}

	}
	
}
