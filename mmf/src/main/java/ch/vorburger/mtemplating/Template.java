package ch.vorburger.mtemplating;

import java.io.Reader;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class Template {
	public Template(Class<?> parameterClass, Reader reader) {
		super();
		this.parameterClass = parameterClass;
		this.reader = reader;
	}

	// TODO Merge these two into on, and handle split inside template? 
	public String dottedPackageName;
	public String className;
	
//	public final LinkedList<Class<?>> typesToImport = new LinkedList<Class<?>>();
	
	public final Class<?> parameterClass;
	public String parameterVariableName = "p";
	
	public String expressionEscapeStartTag = "<%=";
	public String expressionEscapeEndTag = "=%>";
	
	public String codeEscapeStartTag = "<%";
	public String codeEscapeEndTag = "%>";

	public final Reader reader;

}
