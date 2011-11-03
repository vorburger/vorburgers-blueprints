package ch.vorburger.blueprints.data.meta.spi;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ch.vorburger.blueprints.data.meta.Type;

/**
 * Registery of Simple (Leaf) Types.
 *
 * @author Michael Vorburger
 */
public class SimpleTypeRegistry {

	private static final Map<Class<?>, Type> map = new HashMap<Class<?>, Type>();
	
	/**
	 * Returns the SimpleTypeImpl for klass, if any.
	 * 
	 * @param klass Java Class (e.g. String, Long etc. or SqlDate, JODA time; and similar)
	 * @return Type, or null if this is not a (registered) Simple Type
	 */
	public static Type getSimpleType(Class<?> klass) {
		return map.get(klass);
	}

	public static Type registerSimpleType(Class<?> klass) {
		Type type = map.get(klass);
		if (type == null) {
			synchronized (map) {
				type = new SimpleTypeImpl(klass);
				map.put(klass, type);
			}
		}
		return type;
	}
	
	static {
		registerSimpleType(String.class);
		registerSimpleType(Long.class);
		registerSimpleType(Boolean.class);
		registerSimpleType(Integer.class);
		registerSimpleType(Short.class);
		registerSimpleType(Byte.class);
		registerSimpleType(Character.class);
		registerSimpleType(Double.class);
		registerSimpleType(Float.class);
		registerSimpleType(Date.class);
		registerSimpleType(BigDecimal.class);
		registerSimpleType(BigInteger.class);
	}
	
}
