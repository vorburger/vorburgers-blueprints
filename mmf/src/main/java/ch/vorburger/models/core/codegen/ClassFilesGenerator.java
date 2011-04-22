package ch.vorburger.models.core.codegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import ch.vorburger.models.core.meta.gen.Class;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 */
public class ClassFilesGenerator {

	static public void generate(File rootDir, Class<?> klass) throws IOException {
		if (!rootDir.exists())
			throw new IllegalArgumentException(rootDir + " doesn't exist");
		
		File srcDir = new File(rootDir, ClassInterfaceGenerator.packageInDottedForm(klass).replace('.', '/'));
		srcDir.mkdirs();
		
		File javaSourceFile = new File(srcDir, klass.name() + ".java");
		Writer writer = new FileWriter(javaSourceFile);
		ClassInterfaceGenerator.generate(klass, writer, true);
		writer.close();
	}

}
