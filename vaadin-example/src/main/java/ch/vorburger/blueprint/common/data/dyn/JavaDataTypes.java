package ch.vorburger.blueprint.common.data.dyn;

import java.util.Date;

import ch.vorburger.blueprint.common.data.DataType;

/**
 * Default DataTypes for common Java Types.
 *  
 * Note that this is a package local implementation class - there is no need to expose it.
 * 
 * @author Michael Vorburger
 */
class JavaDataTypes {
	// TODO Confirm that there is no need to expose this and package-local is OK...

	// TODO This could (and probably should!) be rewritten to just use a new JavaDataType with a Cache instead of this switch/case
	public static DataType get(Class<?> javaClassDataType) {
		if (javaClassDataType.isAssignableFrom(String.class)) {
			return STRING;
		} else if (javaClassDataType.isAssignableFrom(Date.class)) {
			return DATE;
		}
		throw new IllegalArgumentException("Don't know how to get DataType for " + javaClassDataType);
	}

	private static final DataType STRING = new JavaDataType(String.class); 
	private static final DataType DATE = new JavaDataType(Date.class); 

	public static class JavaDataType extends DataTypeImpl {
		public JavaDataType(Class<?> javaType) {
			super("Java:" + javaType.getName(), javaType);
		}
	}

}
