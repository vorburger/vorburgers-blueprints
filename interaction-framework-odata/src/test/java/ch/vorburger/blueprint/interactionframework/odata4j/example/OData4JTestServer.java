package ch.vorburger.blueprint.interactionframework.odata4j.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.odata4j.producer.ODataProducer;
import org.odata4j.producer.resources.CrossDomainResourceConfig;
import org.odata4j.producer.resources.ODataProducerProvider;
import org.odata4j.producer.resources.ODataResourceConfig;
import org.odata4j.producer.server.JerseyServer;

import com.sun.jersey.api.container.filter.LoggingFilter;

/**
 * OData4J/Jersey Test Server Launcher Util.
 *
 * Strongly "inspired" by/based on http://odata4j.googlecode.com/svn/tags/0.4/odata4j-core/src/test/java/org/odata4j/examples/producer/ProducerUtil.java ... ;-)
 */
public class OData4JTestServer {

	public static JerseyServer startODataServer(String baseUri, ODataProducer producer) {
        // register the producer as the static instance, then launch the http server
		// TODO hoha - what is this, why does it have to be static?
		ODataProducerProvider.setInstance(producer);
		
        JerseyServer server = new JerseyServer(baseUri);
        server.addAppResourceClasses(new ODataResourceConfig().getClasses());
        server.addRootResourceClasses(new CrossDomainResourceConfig().getClasses());

        server.addJerseyRequestFilter(LoggingFilter.class); // log all requests

        // server.addHttpServerFilter(new WhitelistFilter("127.0.0.1","0:0:0:0:0:0:0:1%0")); // only allow local requests
        server.start();
        
        return server;
    }

	public static void main(String endpointUri, ODataProducer producer) {
		JerseyServer server = startODataServer(endpointUri, producer);
        System.out.println("Press any key to exit");
        OData4JTestServer.readLine();
        server.stop();
	}

    private static void readLine(){
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }

}
