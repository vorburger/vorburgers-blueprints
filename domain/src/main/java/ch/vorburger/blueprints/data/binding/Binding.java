package ch.vorburger.blueprints.data.binding;

import java.util.Map;

import ch.vorburger.blueprints.data.DataObject;

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

	void mapFromTo(Map<String, DataObject> dataObjectNameMap) throws BindingException;

	void mapFromTo(NamedDataObject... namedDataObjects) throws BindingException;

	// TODO mapReverseToFrom() ?


	public static class NamedDataObject {
		String name;
		DataObject dataObject;

		NamedDataObject(String name, DataObject dataObject) {
			this.name = name;
			this.dataObject = dataObject;
		}
	}

}