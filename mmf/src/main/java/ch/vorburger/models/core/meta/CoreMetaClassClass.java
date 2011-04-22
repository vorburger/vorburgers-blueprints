package ch.vorburger.models.core.meta;

import ch.vorburger.models.core.meta.gen.Class;
import ch.vorburger.models.core.meta.gen.Object;

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
public abstract class CoreMetaClassClass implements Class {
	
	@Override
	public Object newObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
