package ch.vorburger.mtemplating;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Ignore;
import org.junit.Test;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class GeneratorGeneratorTest {

	@Test
	public void testGeneratingSomeTextTemplateEngine() throws IOException {
		// TODO Helper which constructs target File from package (but keep core on abstract Writer!)
		// TODO create missing directories in that helper also...
		Writer w = new FileWriter("target/src/test/ch/vorburger/mtemplating/test/gen");
		
		Template t = new Template();
		t.className = "SomeTestTextGenerator";
		t.dottedPackageName = "ch.vorburger.mtemplating.test.gen";
		t.parameterClass = SomeTestTemplateInput.class;
		GeneratorGenerator.generateIt(w, t);
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
	}
	
	@Test
	@Ignore // TODO Implement
	public void testSimpleOnTheFlyTemplate() throws IOException {
		// Writer w = new StringWriter(); // org.apache.commons.io.output.StringBuilderWriter would be more efficient
		// TODO Feed that into compiler, without writing file, and execute it
	}
}
