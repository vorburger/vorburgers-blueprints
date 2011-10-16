package ch.vorburger.blueprints.objects;

/**
 * Factory for Objects.
 *
 * @author Michael Vorburger
 */
public interface ObjectFactory<T> {

	// TODO This was created for something which I ended up not doing; if this util is not going to be used elsewhere, completely delete it again later.
	
	T getObject(); 
	
}
