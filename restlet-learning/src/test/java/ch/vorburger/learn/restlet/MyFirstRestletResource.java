package ch.vorburger.learn.restlet;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public class MyFirstRestletResource extends ServerResource {

	@Get
	public String getResource() {
		return "Hello World!";
	}

}
