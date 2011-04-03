package ch.vorburger.uftam.sample.model.representation;

import java.util.Date;

import ch.vorburger.uftam.model.representation.DataList;
import ch.vorburger.uftam.sample.model.domain.LineItem;

public interface OrderView {

	String getCustomerName();

	Date getDate();

	void setDate(Date date);

	/**
	 * Line Items sub-elements. contrary to CustomerShort, the first page (or
	 * all if few) LineItems are "in-lined" (not just linked) in this
	 * representation.
	 */
	DataList<LineItem> getFirstOrders(/* NO DataListRequest argument here! */);
}
