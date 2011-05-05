package ch.vorburger.blueprint.disrest.core.dyn.meta;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface SimpleDataTypeType extends DataOrResourceType {

	String name();
	
	Class<?> javaType();
	
}
