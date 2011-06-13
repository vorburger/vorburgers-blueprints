package ch.vorburger.blueprint.interactionframework.resources.uri;

/**
 * A Resource URI implemented using a java.net.URI.
 * 
 * @author Michael Vorburger
 */
class JavaNetURI implements URI {
	// NOTE: This is INTENTIONALLY package local - no need to expose this impl class!
	
	private static final long serialVersionUID = -1445052839950302580L;

	private final java.net.URI javaNetURI;

	public JavaNetURI(java.net.URI javaNetURI) {
		this.javaNetURI = javaNetURI;
	}

	@Override
	public int hashCode() {
		return javaNetURI.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return javaNetURI.equals(obj);
	}

	@Override
	public String toString() {
		return javaNetURI.toString();
	}
	
}
