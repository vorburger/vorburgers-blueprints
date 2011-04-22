package ch.vorburger.models.core.meta.gen.impl;

import ch.vorburger.models.core.id.IdImpl;
import ch.vorburger.models.core.meta.gen.Class;
import ch.vorburger.models.core.meta.gen.Field;
import ch.vorburger.models.core.meta.gen.Type;
import ch.vorburger.models.core.meta.gen.id.FieldId;
import ch.vorburger.models.core.meta.gen.id.NamedThingInClassId;
import ch.vorburger.models.core.meta.gen.impl.id.FieldIdImpl;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
// TODO @Generated !
// TODO remove public - but then how do I build CoreMetaPackage ?! 
public class FieldImpl extends NamedThingImpl implements Field {
	
	private @SuppressWarnings("rawtypes") Class klass = NullClass.INSTANCE;
	private Type type;

	@Override
	@SuppressWarnings("rawtypes") 
	public Class parent() {
		return klass;
	}

	public Field parent(Class newKlass) {
		if (klass == null) {
			this.klass = NullClass.INSTANCE;
		} else {
			this.klass = newKlass;
		}
		return this;
	}
	
	@Override
	public FieldId _id() {
		return new FieldIdImpl(parent().inPackage().name(), parent().name(), name());
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
