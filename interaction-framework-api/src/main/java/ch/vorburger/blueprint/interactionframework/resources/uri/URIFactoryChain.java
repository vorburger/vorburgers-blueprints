package ch.vorburger.blueprint.interactionframework.resources.uri;

import java.util.LinkedList;
import java.util.List;

/**
 * An URIFactory which tries out a chained list of URIFactory to parse a String URI.
 * 
 * @author Michael Vorburger
 */
public class URIFactoryChain implements URIFactory {
	
	private final List<URIFactory> list = new LinkedList<URIFactory>();
	
	@Override
	public URI parse(String uriString) {
		if (uriString == null) {
			throw new NullPointerException();
		}
		for (URIFactory factory : list) {
			try {
				return factory.parse(uriString);
			} catch (IllegalArgumentException e) {
				// Ignore and try the next one!
			}
		}
		throw new IllegalArgumentException("None of the URIFactories registered in this URIFactoryChain could parse " + uriString);
	}

	public void add(URIFactory factory) {
		list.add(factory);
	}
	
}
