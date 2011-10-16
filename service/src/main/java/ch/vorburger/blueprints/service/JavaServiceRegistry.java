package ch.vorburger.blueprints.service;

import java.util.HashMap;
import java.util.Map;

/**
 * ServiceRegistry looking up Java implementations.
 * 
 * @author Michael Vorburger
 */
public class JavaServiceRegistry implements ServiceRegistry {

	// TODO Am I rebuilding Apache Tuscany here, or is that overkill and a simplified version here makes sense?!
	// TODO Better implement this (internally, without exposing) with Spring or Guice?
	
	private final Map<String, Service> registry = new HashMap<String, Service>();

	/**
	 * Register a service implemented in Java.
	 * 
	 * @param javaService Java service instance
	 * @param methodName Name of method on javaService object to register
	 * 
	 * @throws IllegalArgumentException if javaService is invalid
	 */
	public void register(Object javaService, String methodName) {
		synchronized (registry) {
			if (javaService == null)
				throw new IllegalArgumentException("javaService is null");
			String name = javaService.getClass().getCanonicalName();
			if (name == null) 
				throw new IllegalArgumentException("javaService Object does not have a canonical name to register it under");
			if (methodName == null || methodName.trim().isEmpty())
				throw new IllegalArgumentException("method is null or empty");
			name = name + "." + methodName;
			
			Service service = new JavaServiceImpl(javaService, methodName);
			registry.put(name, service);
		}
	}

	@Override
	public Service lookup(String fullyQualifiedServiceName) {
		Service service = registry.get(fullyQualifiedServiceName);
		if (service == null)
			throw new IllegalArgumentException(fullyQualifiedServiceName + " is not registered here");
		return service;
	}

}
