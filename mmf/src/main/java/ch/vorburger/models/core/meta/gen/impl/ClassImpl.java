package ch.vorburger.models.core.meta.gen.impl;

import ch.vorburger.models.core.id.MapOfThingsWithIds;
import ch.vorburger.models.core.id.MapOfThingsWithIdsUtil;
import ch.vorburger.models.core.meta.CoreMetaClassClass;
import ch.vorburger.models.core.meta.gen.Class;
import ch.vorburger.models.core.meta.gen.Field;
import ch.vorburger.models.core.meta.gen.Method;
import ch.vorburger.models.core.meta.gen.NamedThingInPackage;
import ch.vorburger.models.core.meta.gen.Package;
import ch.vorburger.models.core.meta.gen.id.ClassId;
import ch.vorburger.models.core.meta.gen.id.NamedThingInClassId;
import ch.vorburger.models.core.meta.gen.id.NamedThingInPackageId;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
// TODO remove public - but then how do I build CoreMetaPackage ?! 
public class ClassImpl extends CoreMetaClassClass implements Class {

	private Package inPackage = NullPackage.INSTANCE;
	private String name;
	private Class parentClass;
	private MapOfThingsWithIds<NamedThingInClassId, Field> fields;
	
	@Override
	public Package inPackage() {
		return inPackage;
	}

	@Override
	public Class inPackage(Package inPackage) {
		if (inPackage != null) {
			this.inPackage = inPackage;
		} else {
			this.inPackage = NullPackage.INSTANCE;
		}
		return this;
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
	public ClassId _id() {
		throw new IllegalStateException("IMPLEMENT ME");
	}

	@Override
	public MapOfThingsWithIds<NamedThingInClassId, Field> fields() {
		if (fields == null) {
			fields = MapOfThingsWithIdsUtil.newMap();
		}
		return fields;
	}

	@Override
	public MapOfThingsWithIds<NamedThingInClassId, Method> methods() {
		// TODO Auto-generated method stub
		throw new IllegalStateException("IMPLEMENT ME");
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

	@Override
	public boolean isNull() {
		return false;
	}

}
