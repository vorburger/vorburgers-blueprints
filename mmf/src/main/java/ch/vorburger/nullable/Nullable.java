package ch.vorburger.nullable;

/**
 * Marker interface for a "types which may be null".
 * 
 * Classes implementing Nullable may be represented by instances that are subclasses of those
 * classes but implement {@link NullObject}.  
 * 
 * Classes implementing this must override {@link Nullable#isNull()} to return false, unless they
 * are the {@link NullObject}.
 * 
 * Code must use
 * <tt>o.isNull()<tt> (or <tt>o instanceof NullObject<tt>) instead of <tt>o == null<tt>).
 * 
 * @see NullObject
 * 
 * @author Michael Vorburger
 */
public interface Nullable {

	/**
	 * Check if this is a null object.
	 * 
	 * Alternatively
	 * <tt>o instanceof NullObject<tt> may also be used (but never <tt>obj == null<tt>).
	 * 
	 * @return true if this instance is the NullObject (implements {@link NullObject}).
	 */
	boolean isNull();
}
