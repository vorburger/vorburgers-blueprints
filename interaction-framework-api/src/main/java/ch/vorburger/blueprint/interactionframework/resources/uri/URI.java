package ch.vorburger.blueprint.interactionframework.resources.uri;

import java.io.Serializable;

/**
 * URI.
 * 
 * Implementations must be immutable
 * 
 * @author Michael Vorburger & Kai Kreuzer
 */
public interface URI extends Serializable {
	// TODO we don't need Comparable, do we?
	// NOTE: Do NOT extend Cloneable - for Immutable Classes, that makes no sense.
	
	/**
	 * Returns a RFC 2396-compliant URI.
	 * @return the URI in String-ified form
	 */
	@Override
	String toString();
	
	URIFactoryChain Factory = new URIFactoryChain();
	
}
