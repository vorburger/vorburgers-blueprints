package ch.vorburger.models.core.meta.gen.impl;

import ch.vorburger.models.core.meta.gen.Class;
import ch.vorburger.models.core.meta.gen.Field;
import ch.vorburger.models.core.meta.gen.NamedThingInClassId;
import ch.vorburger.models.core.meta.gen.Type;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
// TODO @Generated !
// TODO remove public - but then how do I build CoreMetaPackage ?! 
public class FieldImpl extends NamedThingImpl implements Field {
	
	private @SuppressWarnings("rawtypes") Class klass;
	private Type type;

	@Override
	@SuppressWarnings("rawtypes") 
	public Class parent() {
		return klass;
	}

	@Override
	public NamedThingInClassId _id() {
		throw new IllegalStateException("IMPLEMENT ME");
	}

	@Override
	public Type type() {
		return type;
	}

	@Override
	public Field name(String name) {
		super.name(name);
		return this;
	}

}
