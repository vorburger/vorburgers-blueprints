package ch.vorburger.blueprints.dyna.binding;

import java.util.Map;

/**
 * DataObject-to-DataObject bi-directional binding helper.
 *
 * @see http://static.springsource.org/spring/docs/current/spring-framework-reference/html/validation.html 
 * @see http://java.net/projects/beansbinding/
 * @see http://dozer.sourceforge.net/documentation/about.html
 * 
 * @author Michael Vorburger
 */
public interface Binding {

	void mapFromTo(Map<String, Object> dataObjectNameMap) throws BindingException;

	void mapFromTo(NamedDataObject... namedDataObjects) throws BindingException;

	// TODO mapReverseToFrom() ?


	public static class NamedDataObject {
		String name;
		Object dataObject;

		NamedDataObject(String name, Object dataObject) {
			this.name = name;
			this.dataObject = dataObject;
		}
	}

}