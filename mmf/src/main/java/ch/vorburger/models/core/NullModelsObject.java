package ch.vorburger.models.core;

import ch.vorburger.models.core.meta.gen.Object;
import ch.vorburger.nullable.NullObject;
import ch.vorburger.nullable.Nullable;

/**
 * Marker interface for null {@link Object} (not java.lang.Object but models.Object).
 * 
 * A NullModelsObject is used to represent a not-yet-set (or explicitly set to null) field in a
 * models object. The purpose is to allow object traversal avoiding NullPointerExceptions.
 * 
 * All it's getters for relationships return other NullEntity instances, all it's getters for
 * non-primitive basic fields return null, all it's setters throw an UnsupportedOperationException,
 * all its methods throw an UnsupportedOperationException.
 * 
 * @see NullObject
 * @see Nullable
 * 
 * @author Michael Vorburger
 */
public interface NullModelsObject extends NullObject {

}
