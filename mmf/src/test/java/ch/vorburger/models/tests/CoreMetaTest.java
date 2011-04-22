package ch.vorburger.models.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ch.vorburger.models.core.meta.CoreMeta;


/**
 * Core Meta Test.
 *
 * @author Michael Vorburger
 */
public class CoreMetaTest {

	@Test
	public void testCoreMeta() {
		assertThat(CoreMeta.CLASS_CLASS.name(), equalTo("Class"));
	}
}
