package ch.vorburger.models.core.meta.gen.impl;

import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.meta.CoreMetaClassClass;
import ch.vorburger.models.core.meta.gen.Class;
import ch.vorburger.models.core.meta.gen.Field;
import ch.vorburger.models.core.meta.gen.Method;
import ch.vorburger.models.core.meta.gen.NamedThingInClassId;
import ch.vorburger.models.core.meta.gen.NamedThingInPackageId;
import ch.vorburger.models.core.meta.gen.Package;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
// TODO @Generated !
// TODO remove public - but then how do I build CoreMetaPackage ?! 
public class ClassImpl extends CoreMetaClassClass implements Class {

	private Package _package;
	private String name;
	private Class parentClass;
	
	@Override
	public Package inPackage() {
		return _package;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public Class name(String name) {
		this.name = name;
		return this;
	}

	@Override
	public NamedThingInPackageId _id() {
		return null;
	}

	@Override
	public MapOfThingsWithIds<NamedThingInClassId, Field> fields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapOfThingsWithIds<NamedThingInClassId, Method> methods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class parentClass() {
		return parentClass;
	}

	@Override
	public Class parentClass(Class parentClass) {
		this.parentClass = parentClass;
		return this;
	}

}
