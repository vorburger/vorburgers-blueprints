package ch.vorburger.blueprints.ui.html.i18n.tests;

import static org.junit.Assert.assertEquals;

import java.util.Locale;
import java.util.MissingResourceException;

import org.junit.Test;

/**
 * Learning JDK Messages / Local I18N.
 *
 * @author Michael Vorburger
 */
public class LearnMessages_Test {

	@Test
	public final void learnMessages1() {
		assertEquals("Hello World", Messages.getString("LearnMessages_Test.hello-world", Locale.ENGLISH)); //$NON-NLS-1$ //$NON-NLS-2$
		assertEquals("Hallo Welt", Messages.getString("LearnMessages_Test.hello-world", Locale.GERMAN)); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Test(expected=MissingResourceException.class)
	public final void learnMessagesFailing() {
		Locale.setDefault(Locale.ITALIAN);
		assertEquals("Hello World", Messages.getString("LearnMessages_Test.hello-world", Locale.FRENCH)); //$NON-NLS-1$ //$NON-NLS-2$
	}	
	
	@Test(expected=MissingResourceException.class)
	public final void badKey() {
		Messages.getString("nonex", Locale.FRENCH); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
