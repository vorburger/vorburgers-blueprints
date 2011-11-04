package ch.vorburger.blueprints.data.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ch.vorburger.blueprints.data.DataObjectImplUtil;

/**
 * Test for DataObjectImplUtil.
 *
 * @author Michael Vorburger
 */
public class DataObjectImplUtilTest {

	@Test
	public void testSplitPath() {
		assertNull(DataObjectImplUtil.splitPath("a"));
		
		String[] props = DataObjectImplUtil.splitPath("a.b");
		assertEquals(2, props.length);
		assertEquals("a", props[0]);
		assertEquals("b", props[1]);
		
		props = DataObjectImplUtil.splitPath("aaa.b");
		assertEquals(2, props.length);
		assertEquals("aaa", props[0]);
		assertEquals("b", props[1]);

		props = DataObjectImplUtil.splitPath("a.bbb");
		assertEquals(2, props.length);
		assertEquals("a", props[0]);
		assertEquals("bbb", props[1]);

		props = DataObjectImplUtil.splitPath("aaa.bbb.ccc");
		assertEquals(3, props.length);
		assertEquals("aaa", props[0]);
		assertEquals("bbb", props[1]);
		assertEquals("ccc", props[2]);
	}
}
