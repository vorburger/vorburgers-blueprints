package ch.vorburger.blueprint.interactionframework.model.meta.simple;

import java.util.HashSet;
import java.util.Set;

import ch.vorburger.blueprint.interactionframework.model.meta.DataType;
import ch.vorburger.blueprint.interactionframework.model.meta.EntityType;
import ch.vorburger.blueprint.interactionframework.model.meta.PropertyType;

/**
 * Implementation of EntityType.
 * 
 * This is a typical simple bean style implementation. It will be useful for many use cases. It is
 * however by not means necessarily the only available/possible implementation; typical alternative
 * implementation is a wrapper around some other exists type meta system.
 * 
 * @author Michael Vorburger
 */
public class EntityTypeImpl extends DataStructTypeImpl implements EntityType {

	// TODO Change this... isKey should simply be a flag on Property.
	// TODO addIdPropertyType(String name, DataType valueDataType)

	private final Set<PropertyType> identityProperties = new HashSet<PropertyType>();
	
	public EntityTypeImpl(String name) {
		super(name);
	}

	@Override
	public Set<PropertyType> getIdentityProperties() {
		return identityProperties;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((identityProperties == null) ? 0 : identityProperties.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof EntityTypeImpl))
			return false;
		EntityTypeImpl other = (EntityTypeImpl) obj;
		if (identityProperties == null) {
			if (other.identityProperties != null)
				return false;
		} else if (!identityProperties.equals(other.identityProperties))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntityTypeImpl [identityProperties=").append(identityProperties).append(", super.toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}

}
