package ch.vorburger.models.core.meta.gen.id;

import ch.vorburger.models.core.id.Id;

public interface PackageId extends Id {

	// no name() needed - the toString() does that; we intentionally don't expose how the Id is constructed.
	
}
