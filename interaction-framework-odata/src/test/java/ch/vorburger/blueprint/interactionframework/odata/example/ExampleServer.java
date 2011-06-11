package ch.vorburger.blueprint.interactionframework.odata.example;

import org.odata4j.examples.producer.ProducerUtil;
import org.odata4j.producer.ODataProducer;
import org.odata4j.producer.resources.ODataProducerProvider;

/**
 * TODO Doc
 *
 * @author Michael Vorburger & Kai Kreuzer
 */
public class ExampleServer {

	public static void main(String[] args) {
		
		// TODO remove the ugly .svc suffix - does it still work?!
		
		ODataProducer producer = new ExampleInteractionFrameworkODataProducerImpl();
		ODataProducerProvider.setInstance(producer );
		
		String endpointUri = "http://localhost:8887/InMemoryProducerExample.svc/";
		// TODO where is ProducerUtil?!
        ProducerUtil.hostODataServer(endpointUri);

	}

}
