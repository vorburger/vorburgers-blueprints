package ch.vorburger.appviewsnflows;

/**
 * Flow through an Application.
 * 
 * @author Michael Vorburger
 */
public interface Flow {

	void start();

	<T extends View> T getCurrentView();

}
