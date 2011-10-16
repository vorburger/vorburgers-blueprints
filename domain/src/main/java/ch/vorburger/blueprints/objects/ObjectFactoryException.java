package ch.vorburger.blueprints.objects;

/**
 * Exception when things go awry in ObjectFactory stuff. 
 *
 * @author Michael Vorburger
 */
public class ObjectFactoryException extends Exception {
	private static final long serialVersionUID = -5690980819040215990L;

	// TODO This was created for something which I ended up not doing; if this util is not going to be used elsewhere, completely delete it again later.
	
	public ObjectFactoryException(String msg, Exception e) {
		super(msg, e);
	}

}
