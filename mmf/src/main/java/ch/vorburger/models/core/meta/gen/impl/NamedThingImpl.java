package ch.vorburger.models.core.meta.gen.impl;

import ch.vorburger.models.core.meta.gen.NamedThing;

class NamedThingImpl implements NamedThing {

	private String name;

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public NamedThing name(String name) {
		this.name = name;
		return this;
	}

}
