package ch.vorburger.blueprints.ui.html.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.htmlparser.jericho.Attributes;
import net.htmlparser.jericho.CharStreamSource;
import net.htmlparser.jericho.CharStreamSourceUtil;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.OutputDocument;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.SourceCompactor;
import net.htmlparser.jericho.StartTag;
import net.htmlparser.jericho.StartTagType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.vorburger.blueprints.ui.html.i18n.tests.HTML_I18N_Test;

/**
 * Localizer for HTML.
 * 
 * Replaces &lt;i18n:translation&gt; keys in HTML Template by Messages. 
 * 
 * @author Michael Vorburger
 */
public class HTMLLocalizer {
	// TODO review, is this correct use of SLF4j?
	private static final Logger LOG = LoggerFactory.getLogger(HTML_I18N_Test.class);
	
	private static final String I18N_MESSAGE = "i18n:message";
	// TODO private static final String I18N_ATTRIBUTE = "i18n:attribute";
	
	protected final HTMLTemplateRepository htmlTemplateRepository;
	private final MessageSource messageSource;
	
	private boolean failOnError = true;

	private boolean removeCommentsAndHead = true;

	private boolean compact = true;

	public HTMLLocalizer(HTMLTemplateRepository htmlTemplateRepository, MessageSource messageSource) {
		super();
		this.htmlTemplateRepository = htmlTemplateRepository;
		this.messageSource = messageSource;
	}

	/**
	 * Creates a Locale-specific Template.
	 * 
	 * This may be an expensive operation (due to HTML parsing cost), and you may want to cache the
	 * returned template.
	 * 
	 * @param themeName Name of Theme
	 * @param templateName Name of Template
	 * @param locale Locale to translate Template into
	 * @return Localized HTMLTemplate, as a Reader. A Reader instead of an InputStream is used
	 *         because the Encoding is known.
	 * @throws HTMLTemplateException Error thrown if something went wrong
	 */
	public String /* Reader */ getHTMLTemplate(String themeName, String templateName, Locale locale) throws HTMLTemplateException {
		checkArgs(themeName, templateName, locale);
		Resource templateResource = htmlTemplateRepository.getHTMLTemplate(themeName, templateName);
		return getHTMLTemplate(templateResource, locale);
	}
	
	protected String /* Reader */ getHTMLTemplate(Resource templateResource, Locale locale) throws HTMLTemplateException {
		InputStream is;
		Source source;
		try {
			is = templateResource.getInputStream();
			source = new Source(is);
			is.close();
		} catch (IOException e) {
			String msg = "IOException while opening or parsing Template from " + templateResource.getDescription();
			LOG.error(msg, e);
			throw new HTMLTemplateException(msg, e);
		}

		if (removeCommentsAndHead && compact) {
			CharStreamSource result = removeCommentsAndHead(source);
			String doc = CharStreamSourceUtil.toString(result);
			doc = compact(new Source(doc));
			source = new Source(doc);
		} else if (!removeCommentsAndHead && compact) {
			String doc = compact(source);
			source = new Source(doc);			
		} else if (removeCommentsAndHead && !compact) {
			CharStreamSource result = removeCommentsAndHead(source);
			String doc = CharStreamSourceUtil.toString(result);
			source = new Source(doc);			
		}
		
		// This seems to be better for performance for the source.getAllStartTags() after
		source.fullSequentialParse();
		OutputDocument outputDocument = new OutputDocument(source);
		
		// ---
		// First parsing to find all the i18n:translation...
		//

		List<Element> messageElements = source.getAllElements(I18N_MESSAGE);
		List<I18NMessageAttributes> i18nAttributes = new LinkedList<I18NMessageAttributes>();
		List<StartTag> startTags = source.getAllStartTags();
		for (StartTag startTag : startTags) {
			Attributes attributes = startTag.getAttributes();
			if (attributes != null) {
				String i18n = attributes.getValue(I18N_MESSAGE);
				if (i18n != null) {
					String[] i18nAttributeMessages = i18n.split(",");
					if (i18nAttributeMessages.length < 1) {
						error("Empty i18n:message attribute: " + i18n);
					}
					I18NMessageAttributes messageAttributes = new I18NMessageAttributes();
					i18nAttributes.add(messageAttributes);
					messageAttributes.htmlElementAttributes = attributes;
					messageAttributes.namesToKeys = new LinkedList<I18NMessageAttributeNameKey>();
					for (String i18nAttributeMessageMapping : i18nAttributeMessages) {
						String[] nameKeyArray = i18nAttributeMessageMapping.trim().split(":");
						if (nameKeyArray.length != 2) {
							error("Invalid i18n:message attribute: " + i18n);
						} else {
							I18NMessageAttributeNameKey nameKey = new I18NMessageAttributeNameKey();
							nameKey.attributeName = nameKeyArray[0].trim();
							nameKey.messageKey = nameKeyArray[1].trim();
							messageAttributes.namesToKeys.add(nameKey);
						}
					}
				}
			}
		}
		
		// ---
		// Now actually replacing keys with localized messages...
		//
		for (I18NMessageAttributes oneElementsAttributes : i18nAttributes) {
			Map<String, String> attributes = outputDocument.replace(oneElementsAttributes.htmlElementAttributes, false);
			for (I18NMessageAttributeNameKey nameKey : oneElementsAttributes.namesToKeys) {
				String value = getMessage(locale, nameKey.messageKey, i18nAttributes.toString());
				attributes.put(nameKey.attributeName, value);
			}
			attributes.remove(I18N_MESSAGE);
		}
		for (Element element : messageElements) {
			String key = element.getAttributeValue("key");
			String value = getMessage(locale, key, element.toString());
			outputDocument.replace(element, value);
		}

		// TODO Which Writer to use, how to create Reader... uh, just String for now: 
//		Writer writer;
//		outputDocument.writeTo(writer);
		return outputDocument.toString();
	}

	protected void checkArgs(String themeName, String templateName, Locale locale) {
		if (themeName == null)
			throw new IllegalArgumentException("themeName == null");
		if (templateName == null)
			throw new IllegalArgumentException("templateName == null");
		if (locale == null)
			throw new IllegalArgumentException("locale == null");
	}

	private String getMessage(Locale locale, String key, String locationInfoForErrorMessage) throws HTMLTemplateException {
		if (key == null)
			error("Empty (null) key in: " + locationInfoForErrorMessage);
		String value = messageSource.getMessage(key, locale);
		if (value == null)
			error("No message found for key " + key + " in: " + locationInfoForErrorMessage);
		return value;
	}
	
	private String compact(Source source) {
		SourceCompactor r = new SourceCompactor(source);
		return r.toString();
	}

	private CharStreamSource removeCommentsAndHead(Source source) {
		OutputDocument outputDocument = new OutputDocument(source);
		List<Element> comments = source.getAllElements(StartTagType.COMMENT);
		outputDocument.remove(comments);
		
		Element head = source.getFirstElement(HTMLElementName.HEAD);
		//outputDocument.replace(head, "<head></head>");
		outputDocument.remove(head);
		
		return outputDocument;
//		StringWriter stringWriter = new StringWriter();
//		outputDocument.writeTo(stringWriter);
//		String doc = stringWriter.toString();
//		return doc;
//		return CharStreamSourceUtil.toString(outputDocument);
	}

	private static class I18NMessageAttributeNameKey {
		String attributeName;
		String messageKey;
	}
	
	private static class I18NMessageAttributes {
		Attributes htmlElementAttributes;
		List<I18NMessageAttributeNameKey> namesToKeys;
	}

	private void error(String msg) throws HTMLTemplateException {
		LOG.error(msg);
		if (failOnError)
			throw new HTMLTemplateException(msg);
	}

//	private void fail(String msg, IOException e) throws HTMLTemplateException {
//	LOG.error(msg, e);
//	throw new HTMLTemplateException(msg, e);
//}

	// NOTE Any setters for configurations which change templates must empty the cache in the CachingHTMLLocalizer subclass!
	
	/**
	 * Error Handling flag; true causes HTMLTemplateException, false just logs but continues.
	 */
	public boolean isFailOnError() {
		return failOnError;
	}

	public void setFailOnError(boolean failOnError) {
		this.failOnError = failOnError;
	}

	/**
	 * Strip HTML header and comments?  If true, removes HTML &lt;head&gt; and all &lt;-- comments --&gt;. 
	 */
	public boolean isRemoveCommentsAndHead() {
		return removeCommentsAndHead;
	}

	public void setRemoveCommentsAndHead(boolean removeCommentsAndHead) {
		this.removeCommentsAndHead = removeCommentsAndHead;
	}

	/**
	 * Remove whitespace?If true remove all whitespace in HTML, false leaves HTML as is. 
	 */
	public boolean isCompact() {
		return compact;
	}

	public void setCompact(boolean compact) {
		this.compact = compact;
	}

}
