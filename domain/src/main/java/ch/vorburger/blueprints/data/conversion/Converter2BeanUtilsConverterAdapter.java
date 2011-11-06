package ch.vorburger.blueprints.data.conversion;

import org.apache.commons.beanutils.converters.AbstractConverter;

/**
 * Adapter to turn a Converter implementing the interface from this package into a BeanUtils Converter. 
 *
 * @author Michael Vorburger
 */
public class Converter2BeanUtilsConverterAdapter<S, T> extends AbstractConverter {

	private final Converter<S, T> converter;
	
	public Converter2BeanUtilsConverterAdapter(Converter<S, T> converter) {
		super();
		this.converter = converter;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Object convertToType(Class type, Object value) throws Throwable {
		return converter.convert((S) value);
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected Class getDefaultType() {
		return converter.getTargetClass();
	}

} 
