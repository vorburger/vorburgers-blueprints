package ch.vorburger.mtemplating;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

/**
 * Tests for the IO Utils stuff.
 * 
 * @author Michael Vorburger
 */
public class ReaderUtilTest {

	@Test
	public void testEquals() {
		char[] charArray = { 'h', 'e', 'l', 'l', 'o' };
		assertThat(GeneratorGenerator.equals("hello", charArray), is(true));
		assertThat(GeneratorGenerator.equals("world", charArray), is(false));
		assertThat(GeneratorGenerator.equals(null, null), is(true));
		assertThat(GeneratorGenerator.equals("hello", null), is(false));
		assertThat(GeneratorGenerator.equals(null, charArray), is(false));
		assertThat(GeneratorGenerator.equals("", new char[] {}), is(true));
	}

	@Test
	public void testReaderUtils() throws IOException {
		Reader r = new StringReader("Hello World");
		assertThat(GeneratorGenerator.hasMore(r), is(true));
		assertThat(GeneratorGenerator.check(r, "bla"), is(false));
		assertThat(GeneratorGenerator.check(r, "Hello "), is(true));
		assertThat(GeneratorGenerator.check(r, "World"), is(true));
		assertThat(GeneratorGenerator.hasMore(r), is(false));
	}
}
