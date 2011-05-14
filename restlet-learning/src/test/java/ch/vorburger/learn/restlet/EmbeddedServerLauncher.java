package ch.vorburger.learn.restlet;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class EmbeddedServerLauncher {
	static public void main(String[] args) throws Exception {
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8182);
		// component.getClients().add(Protocol.FILE);

		component.getDefaultHost().attach(new MyFirstRestletApplication());
		component.start();
	}
}
