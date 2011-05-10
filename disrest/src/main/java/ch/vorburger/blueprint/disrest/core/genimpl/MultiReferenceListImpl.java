package ch.vorburger.blueprint.disrest.core.genimpl;

import ch.vorburger.blueprint.disrest.core.MultiReferenceList;
import ch.vorburger.blueprint.disrest.core.Resource;
import ch.vorburger.blueprint.disrest.core.Resources;

/**
 * TODO Doc
 * 
 * @author Michael Vorburger
 * @param <E>
 */
// TODO @Generated
@SuppressWarnings("serial")
public class MultiReferenceListImpl<E extends Resource> implements MultiReferenceList<E> {

	@Override
	public Resources<E> get() throws ch.vorburger.blueprint.disrest.core.Property.PropertyValueUnavailableException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean isAvailable() {
		return true; // TODO
	}

	@Override
	public void set(Resources<E> newValue) throws ch.vorburger.blueprint.disrest.core.Property.PropertyValueUnchangeableException {
		throw new PropertyValueUnchangeableException("TODO"); // TODO
	}

	@Override
	public boolean isChangeable() {
		return true; // TODO
	}

}
