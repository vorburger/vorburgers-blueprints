package ch.vorburger.uftam.sample.model.representation;

import ch.vorburger.uftam.model.representation.DataList;
import ch.vorburger.uftam.model.representation.DataListRequest;
import ch.vorburger.uftam.model.representation.Representation;

public interface CustomerShort extends Representation {

	// Attributes
	// ----------
	
	String getName();

	// Note: E.g. country & state are not transfered!

	// Navigations
	// -----------

	/**
	 * Navigation to Orders. Note that there is no in-line data in this
	 * representation (contrary to OrderView).
	 */
	DataList<OrderView> goToOrders(DataListRequest<OrderView> req);

	CustomerLong goToEditCustomer();

	// Actions
	// -------

	void deleteCustomer(); // ?

}
