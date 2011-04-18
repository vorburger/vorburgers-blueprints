package ch.vorburger.blueprint.common.data.statc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import ch.vorburger.blueprint.common.data.DataProp;
import ch.vorburger.blueprint.common.data.DataStructObject;

/**
 * InvocationHandler.
 * 
 * Note that this is a package local implementation class - there is no need to expose it.
 * 
 * @author Michael Vorburger
 */
class StaticDataStructObjectInvocationHandler implements InvocationHandler {

	private final DataStructObject wrapped;
	private final Class<?> klass;

	@SuppressWarnings("unchecked")
	static <T> T newProxy(Class<T> klass, DataStructObject o) {
		return (T) Proxy.newProxyInstance(klass.getClassLoader(), 
				new Class[] { klass, StaticDataStructObject.class }, 
				new StaticDataStructObjectInvocationHandler(o, klass));
	}
	
	StaticDataStructObjectInvocationHandler(DataStructObject obj, Class<?> klass) {
		this.wrapped = obj;
		this.klass = klass;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Should harden this to check args.length
		if (method.getName().equals("getPropertyValue")) {
			if (DataProp.class.isAssignableFrom(args[0].getClass())) {
				DataProp dp = (DataProp) args[0]; 
				return wrapped.getPropertyValue(dp);
			} else if (args[0].getClass().equals(String.class)) {
				String pN = (String) args[0]; 
				return wrapped.getPropertyValue(pN);
			} else {
				throw new IllegalArgumentException("Couldn't invoke " + method.getName() + " with this argument type " + args[0].getClass().getName());
			}
		} else if (method.getName().startsWith("get")) {
			return wrapped.getPropertyValue(propertyName(method));
		} else if (method.getName().startsWith("set")) {
			DataStructObject r = wrapped.setPropertyValue(propertyName(method), args[0]);
			return newProxy(klass, r);
		} else {
			throw new IllegalArgumentException("Couldn't invoke " + method.getName());
		}
	}

	private String propertyName(Method method) {
		return method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
	}

}
