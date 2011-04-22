package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.meta.gen.Field;
import ch.vorburger.models.core.meta.gen.NamedThing;
import ch.vorburger.models.core.meta.gen.Package;
import ch.vorburger.models.core.meta.gen.impl.ClassImpl;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
@SuppressWarnings("unchecked")
class CoreMeta {

	static ch.vorburger.models.core.meta.gen.Class<NamedThing> NAMEDTHING_CLASS = new ClassImpl().name("NamedThing");
	
	static ch.vorburger.models.core.meta.gen.Class<Package> PACKAGE_CLASS = new ClassImpl();
	static Package PACKAGE = PACKAGE_CLASS.newObject();
	
	static ch.vorburger.models.core.meta.gen.Class<ch.vorburger.models.core.meta.gen.Class> CLASS_CLASS = new ClassImpl();
	static ch.vorburger.models.core.meta.gen.Class CLASS = CLASS_CLASS.newObject();

	static ch.vorburger.models.core.meta.gen.Class<Field> FIELD_CLASS = new ClassImpl();

	static {
		Field namedThing_Class_name_Field = FIELD_CLASS.newObject().name("name");
		// TODO who sets parent of Field to NAMEDTHING_CLASS 
		NAMEDTHING_CLASS.fields().put(namedThing_Class_name_Field);
	}
	
}
