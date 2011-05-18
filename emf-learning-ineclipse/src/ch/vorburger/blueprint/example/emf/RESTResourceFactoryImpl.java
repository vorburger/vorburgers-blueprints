package ch.vorburger.blueprint.example.emf;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;

/**
 * TODO Doc
 *
 * @author Kai Kreuzer & Michael Vorburger
 */
public class RESTResourceFactoryImpl implements Factory {

	@Override
	public Resource createResource(URI uri) {
		return new SampleMemoryResourceImpl(uri);
	}

}
