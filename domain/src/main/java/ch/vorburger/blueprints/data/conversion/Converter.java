package ch.vorburger.blueprints.data.conversion;

/**
 * Type Converter.
 * 
 * This is "strongly inspired by" org.springframework.core.convert.converter.Converter.
 */
public interface Converter<S, T> {

    T convert(S source);

    Class<T> getTargetClass();
    // TODO Class<S> getSourceClass();
    
}
