package ch.vorburger.blueprints.data.meta.spi;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

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
		registerSimpleType(Long.TYPE);
		registerSimpleType(Boolean.class);
		registerSimpleType(Boolean.TYPE);
		registerSimpleType(Integer.class);
		registerSimpleType(Integer.TYPE);
		registerSimpleType(Short.class);
		registerSimpleType(Short.TYPE);
		registerSimpleType(Byte.class);
		registerSimpleType(Byte.TYPE);
		registerSimpleType(Character.class);
		registerSimpleType(Character.TYPE);
		registerSimpleType(Double.class);
		registerSimpleType(Double.TYPE);
		registerSimpleType(Float.class);
		registerSimpleType(Float.TYPE);
		registerSimpleType(Date.class);
		registerSimpleType(BigDecimal.class);
		registerSimpleType(BigInteger.class);
		registerSimpleType(Date.class);
		registerSimpleType(java.util.Date.class);

		// And all of these as well...
		registerSimpleType(Class.class);
		registerSimpleType(File.class);
		registerSimpleType(Locale.class);
		registerSimpleType(Pattern.class);
		registerSimpleType(URL.class);
		
		// Yes, Object properties are "leafs"
		registerSimpleType(Object.class);
		
		// TODO java.util.Collection sub-types are (properly) handled elsewhere?!
	}
	
}
