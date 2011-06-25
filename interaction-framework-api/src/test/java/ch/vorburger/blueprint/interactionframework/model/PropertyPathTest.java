package ch.vorburger.blueprint.interactionframework.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit Test for PropertyPath.
 *
 * @author Michael Vorburger
 */
public class PropertyPathTest {

	@Test
	public void testPropertyPath() {
		PropertyPath path = new PropertyPath("a");
		assertEquals("a", path.toString());
		assertEquals(1, path.getPropertyNames().size());
		assertEquals("a", path.getPropertyNames().get(0));

		path = new PropertyPath("a.b");
		assertEquals("a.b", path.toString());
		assertEquals(2, path.getPropertyNames().size());
		assertEquals("a", path.getPropertyNames().get(0));
		assertEquals("b", path.getPropertyNames().get(1));
		
		path = new PropertyPath("a.b.c");
		assertEquals("a.b.c", path.toString());
		assertEquals(3, path.getPropertyNames().size());
		assertEquals("a", path.getPropertyNames().get(0));
		assertEquals("b", path.getPropertyNames().get(1));
		assertEquals("c", path.getPropertyNames().get(2));
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testPropertyPathImmutability() {
		PropertyPath path = new PropertyPath("a");
		path.getPropertyNames().add("b");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalPropertyPathCharactersSlash() {
		new PropertyPath("a/b");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalPropertyPathCharacterStartingDot() {
		new PropertyPath(".a");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalPropertyPathCharacterTrailingDot() {
		new PropertyPath("a.b.");
	}
	
	@Test(expected=NullPointerException.class)
	public void testIllegalPropertyPathNull() {
		new PropertyPath(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalPropertyPathEmpty() {
		new PropertyPath("");
	}
	
}
