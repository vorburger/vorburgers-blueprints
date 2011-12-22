package ch.vorburger.blueprints.ui.html.i18n.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import ch.vorburger.blueprints.ui.html.i18n.CachingHTMLLocalizer;
import ch.vorburger.blueprints.ui.html.i18n.HTMLLocalizer;
import ch.vorburger.blueprints.ui.html.i18n.HTMLTemplateRepository;
import ch.vorburger.blueprints.ui.html.i18n.MessageSource;
import ch.vorburger.blueprints.ui.html.i18n.Resource;


/**
 * Tests for HTML I18N.
 *
 * @author Michael Vorburger
 */
public class HTML_I18N_Test {

	private HTMLLocalizer factory;

	@Before
	public void beforeTest() {
		final ClasspathResource resource = new ClasspathResource("/sample-transitional.html");
		HTMLTemplateRepository simpleHTMLTemplateRepository = new HTMLTemplateRepository() {
			@Override
			public Resource getHTMLTemplate(String themeName, String templateName) {
				return resource;
			}
		};
		
		MessageSource messageSource = new MessageSource() {
			@Override
			public String getMessage(String key, Locale locale) {
				return "FOO-" + key + "-BAR_in_" + locale.toString();
			}
		};
		
		factory = new CachingHTMLLocalizer(simpleHTMLTemplateRepository, messageSource);
	}

	@Test
	public final void testHTMLTemplate() throws Exception {
		factory.setFailOnError(true);
		factory.setRemoveCommentsAndHead(true);
		factory.setCompact(false);
		
		Locale locale = Locale.ENGLISH;
		String html = factory.getHTMLTemplate("mytheme", "template.html", locale);
		System.out.println(html);
		assertTrue(html.contains("-BAR_in_en"));
		assertTrue(html.contains("<li>FOO-point.one-BAR"));
		assertFalse(html.contains("i18n:message"));
		assertTrue(html.contains("<img src=\"/images/logo1.png\" alt=\"FOO-logo.alt.intag-BAR_in_en\" title=\"FOO-logo.title.intag-BAR_in_en\" >"));
		// TODO assertTrue(html.contains("<img src=\"/images/logo2.png\" alt=\"FOO-logo.alt-BAR_in_en\" title=\"FOO-logo.title-BAR_in_en\">"));
		
		locale = Locale.GERMAN;
		html = factory.getHTMLTemplate("mytheme", "template.html", locale);
//		System.out.println(html);
		assertTrue(html.contains("-BAR_in_de"));
		assertTrue(html.contains("<li>FOO-point.one-BAR"));
		assertFalse(html.contains("i18n:message"));
		assertTrue(html.contains("<img src=\"/images/logo1.png\" alt=\"FOO-logo.alt.intag-BAR_in_de\" title=\"FOO-logo.title.intag-BAR_in_de\" >"));
		// TODO assertTrue(html.contains("<img src=\"/images/logo2.png\" alt=\"FOO-logo.alt-BAR_in_de\" title=\"FOO-logo.title-BAR_in_de\">"));
	}

	@Test
	public final void testOptions() throws Exception {
		factory.setFailOnError(true);
		factory.setRemoveCommentsAndHead(false);
		factory.setCompact(false);
		String html = factory.getHTMLTemplate("mytheme", "template.html", Locale.ITALIAN);
		assertTrue(html.contains("<!--"));
		assertTrue(html.contains("<title>"));
		assertTrue(html.contains("<ul>\n"));
		
		factory.setRemoveCommentsAndHead(true);
		html = factory.getHTMLTemplate("mytheme", "template.html", Locale.ITALIAN);
		assertFalse(html.contains("<!--"));
		assertFalse(html.contains("<title>"));
		assertTrue(html.contains("<ul>\n"));
		assertFalse(html.contains("<ul><li>"));
		
		factory.setCompact(true);
		html = factory.getHTMLTemplate("mytheme", "template.html", Locale.ITALIAN);
//		System.out.println(html);
		assertFalse(html.contains("<!--"));
		assertFalse(html.contains("<title>"));
		assertFalse(html.contains("<ul>\n"));
		assertTrue(html.contains("<ul><li>"));
	}

}
