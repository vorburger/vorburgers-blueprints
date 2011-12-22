package ch.vorburger.blueprints.ui.html.i18n;

import java.io.InputStream;

/**
 * Repository for HTML Templates.
 * 
 * @author Michael Vorburger
 */
public interface HTMLTemplateRepository {

	/**
	 * Obtains a HTML Template from somehwere (e.g. classpath, file system, database).
	 * 
	 * @param themeName Name of Theme
	 * @param templateName Name of Template
	 * 
	 * @return {@link Resource}, with InputStream. An {@link InputStream} instead of a Reader is
	 *         used because the Encoding is not known à priori, and determined from inside the
	 *         template.
	 */
	Resource getHTMLTemplate(String themeName, String templateName);

}
