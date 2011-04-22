package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.meta.gen.Class;

/**
 * TODO Doc
 * 
 * ... this is the non-generateable hard-coded implementation of specific methods of the Core:Meta
 * Class's Class.
 * 
 * @author Michael Vorburger
 */
// TODO can I remove this when I have created the thing which creates bytecode from interfaces on the fly, or will this stay?
// TODO make this package-local instead of public (dyn. RT gen. code inside this same package)
public abstract class CoreMetaClassClass<T> implements Class<T> {

	// private - package local... TODO hm?!  
	java.lang.Class<T> javaTypeClass;

//	public CoreMetaClassClass<T> javaTypeClass(java.lang.Class<T> javaTypeClass) {
//		this.javaTypeClass = javaTypeClass;
//		return this;
//	}
//
//	public java.lang.Class<T> javaTypeClass() {
//		return javaTypeClass;
//	}
	
	@Override
	public T newObject() {
		if (javaTypeClass == null) {
			throw new IllegalStateException(this._id().toString() + " javaTypeClass is not set");
		}
		
		try {
			return javaTypeClass.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalArgumentException(this._id().toString() + " newObject() failed", e);
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException(this._id().toString() + " newObject() failed", e);
		}
	}

}
