package ch.vorburger.blueprints.data.conversion;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Doc
 * 
 * This is "inspired by" org.apache.commons.beanutils.Converter & Co.
 * 
 * @author Michael Vorburger
 */
public class ConversionService {

	// TODO Must we use something like org.apache.commons.beanutils.WeakFastHashMap instead?!
	private final Map<Class<?>, Converter<?, ?>> map = new HashMap<Class<?>, Converter<?, ?>>();
	private Converter<Object, ?> objectConverter;
	
	/**
	 * Convert source object to target type.
	 * 
	 * @param source input object
	 * @param targetType desired type
	 * @return converted object
	 * @throws IllegalArgumentException if no Converter registered for target type
	 */
	public <T> T convert(Object source, Class<T> targetType) throws IllegalArgumentException {
		return getConverter(targetType).convert(source);
	}

	/**
	 * Register a Converter.
	 * 
	 * @param clazz Converter's target type
	 * @param converter the Converter (should NOT be a Converter<Object, T> - Source Type should be anything else than Object)
	 */
	public <T> void register(Converter<?, T> converter) {
		synchronized (map) {
			map.put(converter.getTargetClass(), converter);
		}
	}

	/**
	 * Register the "fallback" Converter, for source Objects not matching any of the other registered Converters.
	 * 
	 * @param objectConverter the Converter which can transform arbitrary Object instances into T
	 */
	public <T> void registerObjectConverter(Converter<Object, T> objectConverter) {
		this.objectConverter = objectConverter;
	}
	
	@SuppressWarnings("unchecked")
	private <S, T> Converter<S, T> getConverter(Class<T> targetType) {
		Converter<?, ?> conv = map.get(targetType);
		if (conv == null) {
			throw new IllegalArgumentException("No Converter registered for: " + targetType);
		}
		return (Converter<S, T>) conv;
	}

}
