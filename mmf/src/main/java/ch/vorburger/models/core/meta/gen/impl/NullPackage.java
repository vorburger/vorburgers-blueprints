package ch.vorburger.models.core.meta.gen.impl;

import ch.vorburger.models.core.NullModelsObject;
import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.meta.gen.Class;
import ch.vorburger.models.core.meta.gen.NamedThing;
import ch.vorburger.models.core.meta.gen.Package;
import ch.vorburger.models.core.meta.gen.SimpleType;
import ch.vorburger.models.core.meta.gen.id.NamedThingInPackageId;
import ch.vorburger.models.core.meta.mixins.annotated.gen.AnnotationType;

/* NOT public */
class NullPackage implements Package, NullModelsObject {
	private NullPackage() {
	}
	static NullPackage INSTANCE = new NullPackage(); 

	@Override
	public boolean isNull() {
		return true;
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
	public MapOfThingsWithIds<NamedThingInPackageId, Class> classes() {
		throw new IllegalStateException();
	}

	@Override
	public MapOfThingsWithIds<NamedThingInPackageId, SimpleType> simpleTypes() {
		throw new IllegalStateException();
	}

	@Override
	public MapOfThingsWithIds<NamedThingInPackageId, AnnotationType> annotationTypes() {
		throw new IllegalStateException();
	}

}
