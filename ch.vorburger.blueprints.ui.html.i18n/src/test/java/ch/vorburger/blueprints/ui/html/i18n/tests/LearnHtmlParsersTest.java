package ch.vorburger.blueprints.ui.html.i18n.tests;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.OutputDocument;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.SourceCompactor;
import net.htmlparser.jericho.StartTagType;

//import nu.validator.htmlparser.common.XmlViolationPolicy;
//import nu.validator.htmlparser.sax.HtmlParser;
//import nu.validator.htmlparser.sax.HtmlSerializer;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;

import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;


/**
 * Tests with code snippets for playing with / learning different HTML Parsers.
 *
 * @author Michael Vorburger
 */
@SuppressWarnings("unused")
public class LearnHtmlParsersTest {

	@Test
	public final void testJericho() throws Exception {
		InputStream is = getClass().getResourceAsStream("/sample-transitional.html");
		assertNotNull(is);
		
		Source source = new Source(is);
		//System.out.println(source.getDebugInfo());
		
//		SourceCompactor r = new SourceCompactor(source);
//		r.writeTo(new OutputStreamWriter(System.out));
		
		OutputDocument outputDocument = new OutputDocument(source);

		List<Element> elements = source.getAllElements("i18n:message");
		for (Element element : elements) {
			String key = element.getAttributeValue("key");
			outputDocument.replace(element, key);
		}

		List<Element> comments = source.getAllElements(StartTagType.COMMENT);
		outputDocument.remove(comments);
		
		outputDocument.writeTo(new OutputStreamWriter(System.out));
		System.out.flush();
	}

/*	
	@Test
	public final void testNU() throws Exception {
		InputStream is = getClass().getResourceAsStream("/sample-transitional.html");
		assertNotNull(is);
		
		HtmlParser parser = new HtmlParser(XmlViolationPolicy.ALLOW);
		ContentHandler serializer = new HtmlSerializer(System.out);
		parser.setContentHandler(serializer);
		// DON'T parser.setErrorHandler(new ErrorHandler());
		
		InputSource source = new InputSource(is);
		source.setEncoding("UTF-8");
		// parser.parse(source);
		System.out.flush();
	}
*/
	

	/**
	 * JSoup does parse the HTML template,
	 * but appears to be unable to select (find) the <i18n:message>,
	 * so it's useless.
	 */
/*	
	@Test
	@Ignore
	public final void testJSoup() throws Exception {
		InputStream is = getClass().getResourceAsStream("/sample-transitional.html");
		assertNotNull(is);
		
		String baseUri = "";
		Document doc = Jsoup.parse(is, "UTF-8", baseUri);
		
		// This fails with org.jsoup.select.Selector$SelectorParseException: Could not parse query 'i18n:message': unexpected token at ':message'
		Elements elements = doc.select("i18n:message");
		for (org.jsoup.nodes.Element element : elements) {
			System.out.println(element);
		}
		//System.out.println(doc.toString());
		// assertEquals("Troisième <b>Point</b>", getById("p3"));
		System.out.flush();
	}
*/

}
