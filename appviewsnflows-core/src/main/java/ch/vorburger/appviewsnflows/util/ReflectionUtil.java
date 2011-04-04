package ch.vorburger.appviewsnflows.util;

import java.lang.reflect.Constructor;

import ch.vorburger.appviewsnflows.View;

/**
 * Utils for Reflection.
 * 
 * @author Michael Vorburger
 */
public class ReflectionUtil {

	/**
	 * Find a suitable Constructor.
	 * 
	 * @param klass Class to reflect on
	 * @param parameterTypes the parameter array
	 * @return first matching Constructor
	 * @throws NoSuchMethodException  if it couldn't be found
	 */
	static public <T> Constructor<T> findConstructor(Class<T> klass, Class<?>... parameterTypes) throws NoSuchMethodException {
		Constructor<T> c = null;
		@SuppressWarnings("unchecked")
		Constructor<T>[] constructors = (Constructor<T>[]) klass
				.getConstructors();
		for (Constructor<T> constructor : constructors) {
			Class<?>[] thisConstructorParameterTypes = constructor
					.getParameterTypes();
			if (thisConstructorParameterTypes.length == parameterTypes.length) {
				boolean match = true;
				for (int i = 0; i < thisConstructorParameterTypes.length
						&& match; i++) {
					if (!thisConstructorParameterTypes[i]
							.isAssignableFrom(parameterTypes[i]))
						match = false;
				}
				if (match)
					return constructor;
			}
		}
		throw new NoSuchMethodException();
	}
}
