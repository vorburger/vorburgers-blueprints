package ch.vorburger.blueprint.interactionframework.resources.uri;

/**
 * Factory to create URI by parsing String.
 * 
 * @author Michael Vorburger
 */
public interface URIFactory {

	/**
	 * Parse a String-ified URI into an URI.
	 * 
	 * @param uriString String representing an URI (never null)
	 * @return URI instance (never null)
	 * @throws IllegalArgumentException if uriString is not parseable by this Factory
	 * @throws NullPointerException if <tt>uriString</tt> is <tt>null</tt>
	 */
	URI parse(String uriString) throws IllegalArgumentException;

}
