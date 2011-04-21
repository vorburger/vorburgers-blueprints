package ch.vorburger.models.plus;

import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.meta.AnnotationType;
import ch.vorburger.models.core.meta.Class;
import ch.vorburger.models.core.meta.NamedAnnotatedThingInPackageId;
import ch.vorburger.models.core.meta.NamedThing;
import ch.vorburger.models.core.meta.Package;
import ch.vorburger.models.core.meta.SimpleType;

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
	public MapOfThingsWithIds<NamedAnnotatedThingInPackageId, Class> classes() {
		throw new UnsupportedOperationException("Cannot list classes yet - TODO");
	}

	@Override
	public MapOfThingsWithIds<NamedAnnotatedThingInPackageId, SimpleType> simpleTypes() {
		throw new UnsupportedOperationException("Cannot list simpleTypes yet - TODO");
	}

	@Override
	public MapOfThingsWithIds<NamedAnnotatedThingInPackageId, AnnotationType> annotationTypes() {
		throw new UnsupportedOperationException("Cannot list annotationTypes yet - TODO");
	}

}
