package ch.vorburger.blueprint.interactionframework.odata4j.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.core.OEntity;
import org.odata4j.edm.EdmDataServices;
import org.odata4j.examples.BaseExample;
import org.odata4j.producer.server.JerseyServer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

/**
 * JUnit Test Case for the Example.
 * 
 * @author Michael Vorburger
 */
public class ExampleLibraryConsumerTest extends BaseExample {

	private static JerseyServer server;
	private static Client client = Client.create();
	private static final String URL = ExampleServer.ENDPOINT_URI;
	private static ODataConsumer consumer = ODataConsumer.create(URL);

	static {
		client.addFilter(new LoggingFilter());
		ODataConsumer.dump.all(true);
	}

	@BeforeClass
	public static void startServer() {
		server = OData4JTestServer.startODataServer(ExampleServer.ENDPOINT_URI, ExampleServer.newExampleProducer());
	}

	@AfterClass
	public static void stopServer() {
		server.stop();
	}

	/**
	 * HTTP GET Helper.
	 * 
	 * @see http://blogs.oracle.com/enterprisetechtips/entry/consuming_restful_web_services_with
	 * 
	 * @param uri the URI to GET
	 * @return Page body (if the HTTP status was 200)
	 * @throws Exception if the server returned something else than status 200
	 */
	private String getRaw(String uri) throws Exception {
		WebResource webResource = client.resource(uri);

		// do NOT use .accept("text/plain") - else it will 406!
		ClientResponse response = webResource.get(ClientResponse.class);
		int status = response.getStatus();
		if (status != 200) {
			throw new Exception("GET " + uri + " returned status " + status + " (instead of 200)");
		}

		return response.getEntity(String.class);
	}

	/**
	 * Let's test that we can get the WADL available at
	 * http://localhost:8887/InMemoryProducerExample.svc/application.wadl
	 */
	@Test
	public void testGetWADL() throws Exception {
		getRaw(URL + "application.wadl");
	}

	/**
	 * According to the WADL available at
	 * http://localhost:8887/InMemoryProducerExample.svc/application.wadl there should be a
	 * "Service Document" (?) available at http://localhost:8887/InMemoryProducerExample.svc/. Let's
	 * test if we can get it.
	 */
	@Test
	public void testGetRootServiceDocument() throws Exception {
		getRaw(URL + "");
	}

	@Test
	public void testReportMetadata() throws Exception {
		// take a look at the service edm
		EdmDataServices meta = consumer.getMetadata();
		reportMetadata(meta);
		meta.getEdmEntitySet("Books");
	}

	@Test
	public void testGetEntitiesAndEntity() throws Exception {
		// retrieve a product entity with a known id
		OEntity havinaCola = consumer.getEntity("Books", 3).execute();
		reportEntity("Havina Cola", havinaCola);

		// list all products
		for (OEntity product : consumer.getEntities("Books").execute()) {
			reportEntity("Book: " + product.getProperty("ISBN").getValue(), product);
		}
	}

}
