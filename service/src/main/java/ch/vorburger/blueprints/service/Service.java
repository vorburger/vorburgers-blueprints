package ch.vorburger.blueprints.service;

import commonj.sdo.DataObject;

/**
 * Service.
 *
 * @author Michael Vorburger
 */
public interface Service {

	DataObject invoke(DataObject request);
	
}
