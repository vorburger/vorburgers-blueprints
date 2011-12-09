package ch.vorburger.uftam.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Launcher for embedded server.
 * 
 * @author Michael Vorburger
 */
public class ServerLauncher {

	public static void main(String[] args) throws Exception {
		ServerLauncher launcher = new ServerLauncher();
		launcher.startServer();
		System.out.println("Jetty started, please go to http://localhost:8080/" + launcher.getContext());
		launcher.server.join();
	}

	private Server server;
	private WebAppContext webAppContext;

    public void startServer() throws Exception {
        server = createServer();

        webAppContext = createWebAppContext();

        webAppContext.setLogUrlOnStart(true);
        // webAppContext.setParentLoaderPriority(true); // not needed...
        // webAppContext.setCompactPath(true);
        webAppContext.setServer(server);
        // this is great: if WAR couldn't start, don't swallow cause, but propagate!
        webAppContext.getServletHandler().setStartWithUnavailable(false);
        server.setHandler(webAppContext);

        // webAppContext.setTempDirectory(...);

        // No sure how much use that is, as we'll terminate this via Ctrl-C, but
        // it doesn't hurt either:
        server.setStopAtShutdown(true);

        server.start();

        if (!webAppContext.isAvailable() || webAppContext.isFailed() || !webAppContext.isRunning()
                || !webAppContext.isStarted() || server.isFailed() || server.isFailed() || !server.isRunning()
                || !server.isStarted()) {
            // We must (try to) STOP the server, otherwise the forked background
            // thread keeps running, and the JVM won't exit (e.g. in JUnit
            // Tests)
            server.stop();
            if (webAppContext.getUnavailableException() != null) {
                throw new IllegalStateException(
                        "Web App in Jetty Server does not seem to have started up; CHECK THE LOG! PS: Chained exception is: ",
                        webAppContext.getUnavailableException());
            } else {
                throw new IllegalStateException(
                        "Web App in Jetty Server does not seem to have started up; CHECK THE LOG! (NO chained exception)");
            }
        }
    }

    protected Server createServer() {
        if (server != null) {
            throw new IllegalStateException("HTTP Server already running, stop it first before starting it again");
        }
        server = new Server();

        final Connector connector = new SelectChannelConnector(); // new SocketConnector();
        connector.setPort(8080);
        connector.setMaxIdleTime(1000 * 60 * 60);
        // connector.setSoLingerTime(-1);
        server.setConnectors(new Connector[] { connector });
        
        return server;
    }

    public void stopServer() throws Exception {
        webAppContext.stop();
        webAppContext = null;
        server.stop();
        server = null;
    }

    protected WebAppContext createWebAppContext() throws Exception {
        webAppContext = new WebAppContext(null, "/" + getContext());
        
        // webAppContext.setBaseResource(...);
        webAppContext.setWar("src/main/webapp");
        return webAppContext;
    }

	private String getContext() {
		return "test";
	}

	
}
