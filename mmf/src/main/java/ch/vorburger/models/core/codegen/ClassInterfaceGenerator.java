package ch.vorburger.models.core.codegen;

import java.io.IOException;
import java.io.Writer;

import ch.vorburger.models.core.meta.gen.Class;
import ch.vorburger.models.core.meta.gen.Field;

/**
 * Generates interfaces from metamodel Class definitions.
 * 
 * @author Michael Vorburger
 */
public class ClassInterfaceGenerator {

	static public void generate(Class<?> klass, Writer writer, boolean forHumanEyes) throws IOException {
		header(klass, writer, forHumanEyes);
		writer.append(" {\n");
		fields(klass, writer, forHumanEyes);
		writer.append("}\n");
	}

	private static void header(Class<?> klass, Writer writer, boolean forHumanEyes) throws IOException {
		writer.append("package ");
		writer.append(packageInDottedForm(klass));
		writer.append(";\n\n");
		
		writer.append("import ");
		writer.append(ch.vorburger.models.core.id.MapOfThingsWithIds.class.getName());
		writer.append(";\n\n");

		if (forHumanEyes) {
			writer.append("@SuppressWarnings({ \"restriction\", \"unused\" })\n");
			writer.append("@javax.annotation.Generated(\"");
			writer.append(ClassInterfaceGenerator.class.getName());
			writer.append("\")\n");
		}
		
		writer.append("public interface ");
		writer.append(klass.name());
		if (klass.parentClass() != null) {
			writer.append(" extends ");
			writer.append(packageInDottedForm(klass));
			writer.append('.');
			writer.append(klass.parentClass().name());
		}
	}

	private static void fields(Class<?> klass, Writer writer, boolean forHumanEyes) throws IOException {
		for (Field field : klass.fields().values()) {
			writer.append('\t');
			writer.append(fieldClass(field));
			writer.append(' ');
			writer.append(field.name());
			writer.append("();\n");

			writer.append('\t');
			writer.append(klass.name());
			writer.append(' ');
			writer.append(field.name());
			writer.append('(');
			writer.append(fieldClass(field));
			writer.append(' ');
			writer.append(field.name());
			writer.append(");\n");
		}
		
	}
	
	private static CharSequence fieldClass(Field field) {
		// TODO This is wrong of course...
		return "String";
	}

	// package-local, as shared by ClassFilesGenerator to know the directory path
	static String packageInDottedForm(Class<?> klass) {
		// TODO don't hard-code package! use prefix read from mixin, and then klass.inPackage().name()
		return "ch.vorburger.models.core.meta.gen.test"; 
	}
	

}
