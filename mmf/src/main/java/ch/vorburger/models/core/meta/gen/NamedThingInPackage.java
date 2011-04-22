package ch.vorburger.models.core.meta.gen;

import ch.vorburger.models.core.id.ThingWithId;
import ch.vorburger.models.core.meta.gen.id.NamedThingInPackageId;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface NamedThingInPackage extends NamedThing, ThingWithId<NamedThingInPackageId> {

	Package inPackage();
	NamedThingInPackage inPackage(Package inPackage);
}
