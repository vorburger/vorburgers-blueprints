package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.meta.gen.NamedThing;
import ch.vorburger.models.core.meta.gen.NamedThingInPackage;
import ch.vorburger.models.core.meta.gen.Package;
import ch.vorburger.models.core.meta.gen.SimpleType;
import ch.vorburger.models.core.meta.gen.id.NamedThingInPackageId;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public enum CoreSimpleTypes implements SimpleType {
	// TODO remove this when I have created the thing which creates bytecode from interfaces on the fly, this is just an instance, which code should create!

	// TODO not sure is this will still be needed - this will (also?!) be in CoreMeta later..

	/**
	 * An ID is a type which corresponds to the following regexp ...
	 */
	// TODO build something into the framework which enforces this?!  RegExp shouldn't be Doc only, but in annotation!!
	// TODO Define exact Regexp in doc above!
	ID,
	
	/**
	 * Model ID.
	 * MIDs can contain, but not start with, an underscore (which is reserved for built-in system IDs). 
	 */
	MID;

	public NamedThing name(String newName) {
		throw new UnsupportedOperationException("Cannot change name of built-in core simple type" + name() + " to " + newName);
	}

	@Override
	public Package inPackage() {
		return CoreMetaPackage.INSTANCE;
	}

	@Override
	public NamedThingInPackageId _id() {
		throw new UnsupportedOperationException("Implement me! (or rather, remove this class ;)");
		// TODO use IdImpl
	}

	@Override
	public NamedThingInPackage inPackage(Package inPackage) {
		throw new UnsupportedOperationException("Cannot change packge");
	}

	@Override
	public boolean isNull() {
		return false;
	}
	
}
