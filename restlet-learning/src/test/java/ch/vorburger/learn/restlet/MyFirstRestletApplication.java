package ch.vorburger.learn.restlet;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public class MyFirstRestletApplication extends Application {

	@Override
	public synchronized Restlet createInboundRoot() {
		Router router = new Router(getContext());

		router.attach("/hello", MyFirstRestletResource.class);

		return router;
	}
}
