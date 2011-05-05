package ch.vorburger.blueprint.disrest.sampletest.statc.interactionmodel;

import static ch.vorburger.blueprint.disrest.core.ReferenceRemotingType.ONLY_REFERENCE;
import ch.vorburger.blueprint.disrest.core.Property;
import ch.vorburger.blueprint.disrest.core.Resource;
import ch.vorburger.blueprint.disrest.core.SingleReference;
import ch.vorburger.blueprint.disrest.core.statc.Id;
import ch.vorburger.blueprint.disrest.core.statc.ReferenceRemoting;

/**
 * Author Resource (Sample/Test).
 * 
 * @author Michael Vorburger
 */
public interface Author extends Resource {

	@Id
	Property<Long> id();

	Property<String> name();

	/**
	 * Get further details about the author. This is modeled like this so that e.g. lists of Authors
	 * don't have to 'drag along' (i.e. transport over remoting boundaries) unnecessary information.
	 */
	// TODO must this be explicit, or could/should links among different 'views' of what underlying
	// is the same... 'resource type' be automatic/implicit? (BTW: Views are not the same
	// "representations" in REST, a Rep. is just about the binary vs. XML vs. JSON vs. XHTML
	// serialization.)
	@ReferenceRemoting(ONLY_REFERENCE)
	SingleReference<AuthorFull> authorDetails();

}
