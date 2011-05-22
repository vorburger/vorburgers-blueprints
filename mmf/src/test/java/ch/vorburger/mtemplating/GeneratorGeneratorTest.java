package ch.vorburger.mtemplating;

import static org.junit.Assert.fail;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Ignore;
import org.junit.Test;

/**
 * TODO Doc
 * 
 * This test must be run twice, as in the first pass it generates code,
 * which it tests in the second pass.  On first run it test the gen. code
 * from the previous run.
 *
 * @author Michael Vorburger
 */
public class GeneratorGeneratorTest {

	@Test
	public void testGeneratingSomeTextTemplateEngine() throws IOException {
		File outputBaseDir = new File("target/generated-sources/mtemplates/");
		iMustBeMovedSomewhereElseLater("/SomeTestText.txt.template", SomeTestTemplateInput.class, outputBaseDir, "ch.vorburger.mtemplating.test.gen");
		// TODO now assert that gen. code is compilable (via Compiler API)  
	}
	
	// TODO Refactor this!
	private void iMustBeMovedSomewhereElseLater(String classpathResourcePath, Class<?> parameterClass, File outputBaseDirectory, String packageName) throws IOException {
		InputStream template = getClass().getResourceAsStream(classpathResourcePath);
		Reader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(template)));
		Template t = new Template(parameterClass, reader);
		
		t.className = classpathResourcePath.substring(classpathResourcePath.lastIndexOf('/') + 1, classpathResourcePath.indexOf('.'));
		t.dottedPackageName = packageName;
		
		outputBaseDirectory.mkdirs();
		File outputPackageDir = new File(outputBaseDirectory, t.dottedPackageName.replace('.', '/'));
		outputPackageDir.mkdirs();
		File outputFile = new File(outputPackageDir, t.className + ".java");
		Writer w = new FileWriter(outputFile);
		
		GeneratorGenerator.generateIt(w, t);
		template.close();
		reader.close();
		w.close();
	}
	
	@Test
	public void testUsingThePreviouslyGeneratedSomeTextTemplateEngine() throws IOException {
		SomeTestTemplateInput i = new SomeTestTemplateInput();
		i.packageName = "foo.bar";
		i.className = "SomeTestTempate";
		i.someNumber = 1234;
		i.helloMessage = "Saluton!";
		
		Writer w = new StringWriter(); // org.apache.commons.io.output.StringBuilderWriter would be more efficient
		// TODO SomeTestTextGenerator.generateIt(w, i);
		// TODO Assert compare file for equality with an existing TXT from src/test/resources, via Commons IO/File Utils (as <scope>test dependency only please)
		System.out.println(w.toString());
		fail("boo!");
	}

	@Test // TODO use this for the GeneratorGenerator directly, remove SomeTestClass.java.template?
	@Ignore
	public void testGeneratingSomeJavaClassTemplateEngine() throws IOException {
		File outputBaseDir = new File("target/generated-sources/mtemplates/");
		iMustBeMovedSomewhereElseLater("/SomeTestClass.java.template", SomeTestTemplateInput.class, outputBaseDir, "ch.vorburger.mtemplating.test.gen");
	}	

	@Test
	@Ignore // TODO Implement
	public void testSimpleOnTheFlyTemplate() throws IOException {
		// Writer w = new StringWriter(); // org.apache.commons.io.output.StringBuilderWriter would be more efficient
		// TODO Feed that into compiler, without writing file, and execute it
	}
}
