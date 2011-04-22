package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.meta.gen.Field;
import ch.vorburger.models.core.meta.gen.NamedThing;
import ch.vorburger.models.core.meta.gen.Package;
import ch.vorburger.models.core.meta.gen.impl.ClassImpl;
import ch.vorburger.models.core.meta.gen.impl.FieldImpl;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CoreMeta {

	public static ch.vorburger.models.core.meta.gen.Class<NamedThing> NAMEDTHING_CLASS = new ClassImpl().name("NamedThing");
	
//	static ch.vorburger.models.core.meta.gen.Class<Package> PACKAGE_CLASS = new ClassImpl();
//	static Package PACKAGE = PACKAGE_CLASS.newObject();
	
	public static ch.vorburger.models.core.meta.gen.Class<ch.vorburger.models.core.meta.gen.Class> CLASS_CLASS = new ClassImpl().name("Class");
	// TODO ?? static ch.vorburger.models.core.meta.gen.Class CLASS = CLASS_CLASS.newObject();

	public static ch.vorburger.models.core.meta.gen.Class<Field> FIELD_CLASS = /* CLASS_CLASS.newObject() */ new ClassImpl().parentClass(NAMEDTHING_CLASS);

	static {
		((CoreMetaClassClass)CLASS_CLASS).javaTypeClass = ClassImpl.class;
		((CoreMetaClassClass)FIELD_CLASS).javaTypeClass = FieldImpl.class;
		
		Field namedThing_Class_name_Field = FIELD_CLASS.newObject().name("name");
		NAMEDTHING_CLASS.fields().put(namedThing_Class_name_Field);
		// TODO who'll set parent of Field to NAMEDTHING_CLASS ?
		// TODO Intro a new (general) 'convenience shortcut' API metho on Map (and Collection) fields to create a new Element.  In thse case of Map the Q is how to decide (and update!) the Key of the Map...
	}
	
}
