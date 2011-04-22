package ch.vorburger.models.core.meta.mixins.annotated.gen;

import java.util.Collection;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface AnnotatedThing {

	// TODO Collection<Annotation> annotations();
	// don't use a Collection, but a Map; like Package/Class and Class/Attribute
	// key here shouldn't be name/ID, but... Annotation's Type, an Annotation type?
}
