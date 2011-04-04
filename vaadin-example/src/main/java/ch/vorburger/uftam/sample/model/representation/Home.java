package ch.vorburger.uftam.sample.model.representation;

import ch.vorburger.uftam.model.representation.DataList;
import ch.vorburger.uftam.model.representation.DataListRequest;

public interface Home {

	DataList<CustomerShort> getCustomers(DataListRequest<CustomerShort> req);
}
