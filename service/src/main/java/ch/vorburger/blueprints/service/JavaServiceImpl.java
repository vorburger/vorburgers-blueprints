package ch.vorburger.blueprints.service;

import commonj.sdo.DataObject;

/**
 * Service bound to a Java implementation.
 *
 * @author Michael Vorburger
 */
/* package local */
class JavaServiceImpl implements Service {

	// TODO Reflection, Method, ...
	
	JavaServiceImpl(Object javaService, String methodName) {
		throw new UnsupportedOperationException("IMPLEMENT ME!");
	}

	@Override
	public DataObject invoke(DataObject request) {
		throw new UnsupportedOperationException("IMPLEMENT ME!");
	}

}
