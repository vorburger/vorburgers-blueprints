package ch.vorburger.blueprints.service;


/**
 * Factory for Service.
 *
 * @author Michael Vorburger
 */
public interface ServiceRegistry {

	Service lookup(String fullyQualifiedServiceName);

}
