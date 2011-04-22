package ch.vorburger.nullable;

/**
 * Marker interface to be implemented by "Null Objects".
 * 
 * Classes implementing NullObject are Singletons. Classes implementing NullObject must override
 * {@link Nullable#isNull()} to return true.
 * 
 * <p>It is recommended that a sub type of NullObject is created for each "kind" of NullObject type,
 * and that the documentation of such subtypes clarifies their exact semantics.
 * 
 * Code must use
 * <tt>o instanceof NullObject<tt> (or <tt>o.isNull()<tt>) instead of <tt>o == null<tt>).
 * 
 * @author Michael Vorburger
 */
public interface NullObject extends Nullable {
}
