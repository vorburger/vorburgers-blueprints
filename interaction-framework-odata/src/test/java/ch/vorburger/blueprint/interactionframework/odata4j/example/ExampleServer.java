package ch.vorburger.blueprint.interactionframework.odata4j.example;

import org.odata4j.producer.ODataProducer;

import ch.vorburger.blueprint.interactionframework.data.example.ExampleResourceRepositoryImpl;

/**
 * Example Server Launcher.
 *
 * @author Michael Vorburger
 */
public class ExampleServer {

	// TODO remove the ugly .svc suffix - does it still work?!
	static final String ENDPOINT_URI = "http://localhost:8887/InMemoryProducerExample.svc/";
	
	public static ODataProducer newExampleProducer() {
		ExampleResourceRepositoryImpl repo = new ExampleResourceRepositoryImpl();
        return new ExampleInteractionFrameworkODataProducerImpl(repo, "LibraryExample");
	}
	
	public static void main(String[] args) {
		OData4JTestServer.main(ENDPOINT_URI, newExampleProducer());
	}

}
