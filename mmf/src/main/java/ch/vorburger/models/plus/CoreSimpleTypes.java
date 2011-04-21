package ch.vorburger.models.plus;

import ch.vorburger.models.core.meta.NamedAnnotatedThingInPackageId;
import ch.vorburger.models.core.meta.NamedThing;
import ch.vorburger.models.core.meta.Package;
import ch.vorburger.models.core.meta.SimpleType;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public enum CoreSimpleTypes implements SimpleType {
	// TODO remove this when I have created the thing which creates bytecode from interfaces on the fly, this is just an instance, which code should create!

	// TODO not sure which package this should be in, and what/how it's going to be used for..

	// TODO build something into the framework which enforces this?!  RegExp shouldn't be Doc only, but in annotation!!

	/**
	 * An ID is a type which corresponds to the following regexp ...
	 */
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
	public Package parent() {
		return CoreMetaPackage.INSTANCE;
	}

	@Override
	public NamedAnnotatedThingInPackageId _id() {
		return new NamedAnnotatedThingInPackageId() {
			
			@Override
			public String packageName() {
				return parent().name();
			}
			
			@Override
			public String name() {
				return name();
			}
			
			@Override
			public int hashCode() { // TODO
				throw new UnsupportedOperationException("I AM NOT YET IMPLEMENTED - FIX ME!");
			}
			
			@Override
			public boolean equals(Object obj) {
				throw new UnsupportedOperationException("I AM NOT YET IMPLEMENTED - FIX ME!");
			}

			@Override
			public String toString() {
				throw new UnsupportedOperationException("I AM NOT YET IMPLEMENTED - FIX ME!");
			}
		};
	}
	
}
