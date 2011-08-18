package ch.vorburger.blueprint.interactionframework.resources;

import java.util.HashSet;
import java.util.Set;

public class MetadataImpl implements Metadata {

	private final Set<ResourceType> entries;
	
	public MetadataImpl() {
		this.entries = new HashSet<ResourceType>();
	}

	@Override
	public Set<ResourceType> getResourceTypes() {
		return entries;
	}

}
