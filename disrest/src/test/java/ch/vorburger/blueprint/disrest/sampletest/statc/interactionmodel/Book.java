package ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel;

import ch.vorburger.blueprint.disrest.core.OperationReturn;
import ch.vorburger.blueprint.disrest.core.Property;
import ch.vorburger.blueprint.disrest.core.Resource;
import ch.vorburger.blueprint.disrest.core.SingleReference;
import ch.vorburger.blueprint.disrest.core.statc.Id;
import ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel.datatypes.ISBN;

/**
 * Book Resource (Sample/Test).
 *
 * @author Michael Vorburger
 */
public interface Book extends Resource {

	// NOTE This is the interaction model, the data (!) model probably has additional attributes such as boolean isActive, which we don't need/want to expose here.

	@Id
	Property<ISBN> isbn();
	
	Property<String> title();
	
	// real-life books have many authors, but just to illustrate multiplicity many vs. single here we'll say a Book has only one Author 
	SingleReference<Author> author();
	
	SingleReference<Reservation> currentReservation();
	
	OperationReturn<Reservation> borrow();
	
	// TODO how to model 'exceptions' - e.g. if a book is already borrowed() then the operation won't succeed...
	
	/**
	 * Book Reservation Resource (Sample/Test).
	 */
	public interface Reservation extends Resource {
		// TODO User borrower, Date from, Date to, int numberOfTimesToDateWasExtended
	}
}