package ch.vorburger.models.core.id;

import java.io.Serializable;


/**
 * Id of something.
 *
 * @author Michael Vorburger
 */
public interface Id extends Serializable {

	/**
	 * String-ified (externalizable) version of the ID of this object.
	 * 
	 * @return the Id as a String
	 */
	@Override
    String toString();

	/*
	 * Must be overridden in implementation!
	 */
	@Override
	public int hashCode();
	
	/*
	 * Must be overridden in implementation!
	 */
	@Override
	public boolean equals(Object obj);
}
