package ch.vorburger.blueprint.disrest.core;


/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface Operation<T> {

	// TODO Doc
	T execute() throws OperationUnavailableException;
	
	// TODO Doc
	boolean isAvailable();
	
	public class OperationUnavailableException extends Exception {

		/**
		 * Constructs a new <code>OperationUnavailableException</code> with the specified detail
		 * message.
		 * 
		 * @param msg the detail message
		 */
		public OperationUnavailableException(String msg) {
			super(msg);
		}
	}
	
}
