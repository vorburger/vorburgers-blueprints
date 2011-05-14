package ch.vorburger.mtemplating;

import java.io.IOException;
import java.io.Writer;

/**
 * Generator.
 * 
 * @param <T> template input type 
 *
 * @author Michael Vorburger
 */
public interface Generator<T> {

	void generate(Writer w, T i) throws IOException;

}
