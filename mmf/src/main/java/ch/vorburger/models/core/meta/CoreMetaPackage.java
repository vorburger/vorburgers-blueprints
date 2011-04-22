package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.meta.gen.Class;
import ch.vorburger.models.core.meta.gen.NamedThingInPackageId;
import ch.vorburger.models.core.meta.gen.NamedThing;
import ch.vorburger.models.core.meta.gen.Package;
import ch.vorburger.models.core.meta.gen.SimpleType;
import ch.vorburger.models.core.meta.mixins.annotated.gen.AnnotationType;

// TODO remove this when I have created the thing which creates bytecode from interfaces on the fly, this is just an instance, which code should create!
final class CoreMetaPackage implements Package {
	private CoreMetaPackage() {
	}
	
	static CoreMetaPackage INSTANCE = new CoreMetaPackage(); 
	
	@Override
	public String name() {
		return "_Core.Meta";
	}

	@Override
	public NamedThing name(String name) {
		throw new UnsupportedOperationException("Cannot change name of built-in core meta package to " + name);
	}

	@Override
	public MapOfThingsWithIds<NamedThingInPackageId, Class> classes() {
		throw new UnsupportedOperationException("Cannot list classes yet - TODO");
	}

	@Override
	public MapOfThingsWithIds<NamedThingInPackageId, SimpleType> simpleTypes() {
		throw new UnsupportedOperationException("Cannot list simpleTypes yet - TODO");
	}

	@Override
	public MapOfThingsWithIds<NamedThingInPackageId, AnnotationType> annotationTypes() {
		throw new UnsupportedOperationException("Cannot list annotationTypes yet - TODO");
	}

}
