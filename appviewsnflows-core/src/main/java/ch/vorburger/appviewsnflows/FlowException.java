package ch.vorburger.appviewsnflows;

/**
 * The Exception thrown when stuff goes wrong around here.
 * 
 * @author Michael Vorburger
 */
public class FlowException extends RuntimeException {
	private static final long serialVersionUID = -7672555086777616451L;

	public FlowException(String message) {
		super(message);
	}

	public FlowException(String message, Throwable cause) {
		super(message, cause);
	}

}
