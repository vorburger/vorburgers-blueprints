package ch.vorburger.models;

import java.io.File;

import ch.vorburger.models.core.codegen.ClassFilesGenerator;
import ch.vorburger.models.core.meta.CoreMeta;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class CoreMetaGenerator {

	public static void main(String[] args) throws Exception {
		File srcDir = new File("src/main/java/");
		ClassFilesGenerator.generate(srcDir, CoreMeta.NAMEDTHING_CLASS);
		ClassFilesGenerator.generate(srcDir, CoreMeta.CLASS_CLASS);
	}


}
