package ch.vorburger.blueprints.dyna.access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ch.vorburger.blueprints.dyna.access.PathResolvingPropertyAccessorService;

/**
 * Test for DataObjectImplUtil.
 *
 * @author Michael Vorburger
 */
public class PathResolvingPropertyAccessorServiceTest {

	@Test
	public void testSplitPath() {
		assertNull(PathResolvingPropertyAccessorService.splitPath("a"));
		
		String[] props = PathResolvingPropertyAccessorService.splitPath("a.b");
		assertEquals(2, props.length);
		assertEquals("a", props[0]);
		assertEquals("b", props[1]);
		
		props = PathResolvingPropertyAccessorService.splitPath("aaa.b");
		assertEquals(2, props.length);
		assertEquals("aaa", props[0]);
		assertEquals("b", props[1]);

		props = PathResolvingPropertyAccessorService.splitPath("a.bbb");
		assertEquals(2, props.length);
		assertEquals("a", props[0]);
		assertEquals("bbb", props[1]);

		props = PathResolvingPropertyAccessorService.splitPath("aaa.bbb.ccc");
		assertEquals(3, props.length);
		assertEquals("aaa", props[0]);
		assertEquals("bbb", props[1]);
		assertEquals("ccc", props[2]);
	}
}
