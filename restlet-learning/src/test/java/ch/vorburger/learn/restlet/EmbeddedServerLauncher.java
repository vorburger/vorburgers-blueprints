package ch.vorburger.learn.restlet;

import java.io.IOException;

import org.junit.Test;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class EmbeddedServerLauncher {
	static public void main(String[] args) throws Exception {
		startServer();
	}
	
	@Test
	public static void testRestletClient() throws Exception {
		ClientResource clientResource = new ClientResource("http://www.restlet.org");
		clientResource.get().write(System.out);
	}
	

	private static Component startServer() throws Exception {
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8182);
		// component.getClients().add(Protocol.FILE);

		component.getDefaultHost().attach(new MyFirstRestletApplication());
		component.start();
		return component;
	}
}
