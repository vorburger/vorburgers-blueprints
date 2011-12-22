package ch.vorburger.blueprints.ui.html.i18n;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HTMLLocalizer with Cache.
 * 
 * Typically only one instance of this would be created. 
 * 
 * @author Michael Vorburger
 */
public class CachingHTMLLocalizer extends HTMLLocalizer {

	// TODO Read up on the Spring Caching abstraction... can it be used for something like (instead of) this?  How does it support "refreshing" (eviction) ?§
	
	// TODO Write a Test for this

	// TODO Pair-review this class with somebody for 4 eyes concurrency issues double check... synchronized keyword

	// TODO review, is this correct use of SLF4j?
	private static final Logger LOG = LoggerFactory.getLogger(CachingHTMLLocalizer.class);

	private final Map<CacheKey, CacheValue> cache = new HashMap<CacheKey, CacheValue>();

	public CachingHTMLLocalizer(HTMLTemplateRepository htmlTemplateRepository, MessageSource messageSource) {
		super(htmlTemplateRepository, messageSource);
	}

	public String /* Reader */getHTMLTemplate(String themeName, String templateName, Locale locale) throws HTMLTemplateException {
		checkArgs(themeName, templateName, locale);
		Resource templateResource = htmlTemplateRepository.getHTMLTemplate(themeName, templateName);
		long lastModified = getLastModified(templateResource);
		CacheKey cacheKey = new CacheKey(themeName, templateName, locale);
		CacheValue cachedValue = cache.get(cacheKey);
		if (cachedValue == null) {
			// TODO LOG.debug("HTML Template {1} for Theme {0} in Locale {2} not found in Cache, so loading & parsing it", themeName, templateName, locale);
			cachedValue = reload(templateResource, locale, cacheKey);
		} else if (cachedValue.lastModified != lastModified ) {
			// TODO LOG.trace("HTML Template {1} for Theme {0} in Locale {2} found in Cache but source changed, so re-loading it (Timestamp before {3}, now {4})", themeName, templateName, locale, cachedValue.lastModified, lastModified);
			cachedValue = reload(templateResource, locale, cacheKey);
		} else {
			// TODO LOG.trace("HTML Template {1} for Theme {0} in Locale {2} found in Cache!", themeName, templateName, locale);
			// Don't need to do anything else
		}
		return cachedValue.html;
	}

	// NOTE: synchronized 
	protected synchronized CacheValue reload(Resource templateResource, Locale locale, CacheKey cacheKey) throws HTMLTemplateException {
		CacheValue cachedValue;
		String html = getHTMLTemplate(templateResource, locale);
		cachedValue = new CacheValue(getLastModified(templateResource), html);
		cache.put(cacheKey, cachedValue);
		return cachedValue;
	}
	
	private long getLastModified(Resource resource) throws HTMLTemplateException {
		try {
			return resource.lastModified();
		} catch (IOException e) {
			String msg = "IOException while getting lastModified() from " + resource.getDescription();
			LOG.error(msg, e);
			throw new HTMLTemplateException(msg, e);
		}
	}

	@Override
	public synchronized void setRemoveCommentsAndHead(boolean removeCommentsAndHead) {
		clearCache();
		super.setRemoveCommentsAndHead(removeCommentsAndHead);
	}

	@Override
	public synchronized void setCompact(boolean compact) {
		clearCache();
		super.setCompact(compact);
	}

	private synchronized void clearCache() {
		cache.clear();
	}

	private static class CacheKey {
		private final String themeName;
		private final String templateName;
		private final Locale locale;

		CacheKey(String themeName, String templateName, Locale locale) {
			super();
			this.themeName = themeName;
			this.templateName = templateName;
			this.locale = locale;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((locale == null) ? 0 : locale.hashCode());
			result = prime * result + ((templateName == null) ? 0 : templateName.hashCode());
			result = prime * result + ((themeName == null) ? 0 : themeName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof CacheKey))
				return false;
			CacheKey other = (CacheKey) obj;
			if (locale == null) {
				if (other.locale != null)
					return false;
			} else if (!locale.equals(other.locale))
				return false;
			if (templateName == null) {
				if (other.templateName != null)
					return false;
			} else if (!templateName.equals(other.templateName))
				return false;
			if (themeName == null) {
				if (other.themeName != null)
					return false;
			} else if (!themeName.equals(other.themeName))
				return false;
			return true;
		}

	}

	private static class CacheValue {
		private final long lastModified;
		private final String html;

		CacheValue(long lastModified, String html) {
			super();
			this.lastModified = lastModified;
			this.html = html;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((html == null) ? 0 : html.hashCode());
			result = prime * result + (int) (lastModified ^ (lastModified >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof CacheValue))
				return false;
			CacheValue other = (CacheValue) obj;
			if (html == null) {
				if (other.html != null)
					return false;
			} else if (!html.equals(other.html))
				return false;
			if (lastModified != other.lastModified)
				return false;
			return true;
		}
	}
}
