package ch.vorburger.models.core.meta.gen.impl;

import ch.vorburger.models.core.NullModelsObject;
import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.meta.gen.Class;
import ch.vorburger.models.core.meta.gen.NamedThing;
import ch.vorburger.models.core.meta.gen.NamedThingInPackage;
import ch.vorburger.models.core.meta.gen.Package;
import ch.vorburger.models.core.meta.gen.id.NamedThingInPackageId;

/* NOT public */
class NullClass implements Class, NullModelsObject {
	private NullClass() {
	}
	static NullClass INSTANCE = new NullClass(); 

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public Package inPackage() {
		return NullPackage.INSTANCE;
	}

	@Override
	public NamedThingInPackage inPackage(Package inPackage) {
		throw new IllegalStateException();
	}

	@Override
	public String name() {
		// This is OK (because it's a field of a native Java type) - we can't do any better 
		return null;
	}

	@Override
	public NamedThing name(String name) {
		throw new IllegalStateException();
	}

	@Override
	public NamedThingInPackageId _id() {
		throw new IllegalStateException();
	}

	@Override
	public Class parentClass() {
		return NullClass.INSTANCE;
	}

	@Override
	public Class parentClass(Class parentClass) {
		throw new IllegalStateException();
	}

	@Override
	public MapOfThingsWithIds fields() {
		// TODO MUST RETURN EMPTY MAP
		throw new IllegalStateException("NOT YET IMPLEMENTED");
	}

	@Override
	public MapOfThingsWithIds methods() {
		// TODO MUST RETURN EMPTY MAP
		throw new IllegalStateException("NOT YET IMPLEMENTED");
	}

	@Override
	public Object newObject() {
		// This is OK (because it's a method, not a field)
		throw null;
	}

}
