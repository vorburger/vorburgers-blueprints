package ch.vorburger.blueprint.common.data.statc;

import ch.vorburger.blueprint.common.data.DataStructObject;
import ch.vorburger.blueprint.common.data.dyn.DynDataStructObjectFactory;

/**
 * Factory which can create "statically" typed DataStructObject instances.
 * 
 * @author Michael Vorburger
 */
public class StaticDataStructObjectFactory {
	private StaticDataStructObjectFactory() {
	}

	// TODO why separate dyn & static packages, actually, and not just one DataStructFactory with two methods?!

	// T does not necessarily have to extend DataStructObject
	// TODO Could simplify this to one param by using reflection klass, or TypeLiteral?
	public static <T> T create(Class<T> klass, StaticDataStruct<T> struct) {
		DataStructObject o = DynDataStructObjectFactory.create(struct);
		return StaticDataStructObjectInvocationHandler.newProxy(klass, o);
	}
	
	// TODO This could be tackled completely differently, e.g. via Janino/BCEL/ASM, instead of Proxy...
}
