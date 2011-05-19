package ch.vorburger.learnapt;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Completion;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

/**
 * Example 'APT' Processor.
 * 
 * @see http://wiki.netbeans.org/FaqApt
 * @see http://www.javaspecialists.eu/archive/Issue167.html
 * @see http://code.google.com/p/acris/wiki/CodeGenerationPlatform
 * @see http://download.oracle.com/javase/6/docs/api/javax/annotation/processing/Processor.html
 * 
 * @author Michael Vorburger
 */
@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("ch.vorburger.learnapt.SomeAnnotation")
// ? @SupportedOptions()
// TODO @SupportedAnnotationTypes("*") is it called for EVERYTHING?
//		"Set of elements which comes as first parameter holds all the java classes which are annotated with supported annotation (note: if the supportedAnnotationType is asterix "*" then the input set is empty and you have to fetch annotated java classes in your own)"
public class SampleProcessor extends AbstractProcessor {

	/** "Each implementation of a Processor must provide a public no-argument constructor to be used by tools to instantiate the processor." */
    public SampleProcessor() {}  

// TODO getCompletions()
//	@Override
//	public Iterable<? extends Completion> getCompletions(Element element,
//			AnnotationMirror annotation, ExecutableElement member,
//			String userText) {
//		// TODO Auto-generated method stub
//		return super.getCompletions(element, annotation, member, userText);
//	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		// TODO called twice?  needs optimize?
        System.out.println("processingOver: " + roundEnv.processingOver());

		for (TypeElement element : annotations){
            System.out.println(element.getQualifiedName());
            this.processingEnv.getMessager().printMessage(Kind.WARNING, "Got you: " + element.getQualifiedName(), element);
        }
		
		for (Element e : roundEnv.getElementsAnnotatedWith(SomeAnnotation.class)) {
//            if (e.getKind() != ElementKind.FIELD) {
//                processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, "Not a field", e);
//                continue;
//            }
            this.processingEnv.getMessager().printMessage(Kind.WARNING, "Aha: " + e.toString());
            TypeElement clazz = (TypeElement) e; // NOT .getEnclosingElement();
            String name = capitalize(e.getSimpleName().toString());
            
			try {
				// NOTE additional arg. to createSourceFile for originatingElements
	            JavaFileObject f = processingEnv.getFiler().createSourceFile(clazz.getQualifiedName() + "Extras", e);
	            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Creating " + f.toUri());
	            Writer w = f.openWriter();
	            try {
	                PrintWriter pw = new PrintWriter(w);
	                pw.println("package " + clazz.getEnclosingElement().getSimpleName() + ";");
	                // TODO @Generated
	                pw.println("public abstract class " + clazz.getSimpleName() + "Extras {");
	                pw.println("    protected " + clazz.getSimpleName() + "Extras() {}");
	                TypeMirror type = e.asType();
	                pw.println("    /** Handle something. */");
	                pw.println("    protected final void handle" + name + "(" + type + " value) {");
	                pw.println("        System.out.println(value);");
	                pw.println("    }");
	                pw.println("}");
	                pw.flush();
	            } finally {
	                w.close();
	            }
	        } catch (IOException x) {
	            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, x.toString());
	        }
		}
		return true; // TODO hm.. what if there are others?
	}

	private static String capitalize(String name) {
        char[] c = name.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        return new String(c);
    }
}
