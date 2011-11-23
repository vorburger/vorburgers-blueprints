package ch.vorburger.blueprints.dyna;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple DynaBean.
 * 
 * As it's not backed by any "type system", it can not
 * validate property names & types; and as such is mainly intended for simple testing, only.
 *
 * @author Michael Vorburger
 */
public class SimpleDynaBean implements DynaBean {
	
	private final Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public Object get(String propertyNamePath) throws IllegalArgumentException {
		checkPath(propertyNamePath);
		return map.get(propertyNamePath);
	}

	@Override
	public void set(String propertyNamePath, Object value) throws IllegalArgumentException {
		checkPath(propertyNamePath);
		map.put(propertyNamePath, value);
	}

	private void checkPath(String path) {
		if (path.indexOf('.') > -1) {
			throw new IllegalArgumentException("This implementation only supports simple properties");
		}
		else if (path.indexOf('/') > -1) {
			throw new IllegalArgumentException("This implementation only supports simple properties");
		}
		else if (path.indexOf('[') > -1) {
			throw new IllegalArgumentException("This implementation only supports simple properties");
		}
		else if (path.indexOf('@') > -1) {
			throw new IllegalArgumentException("This implementation only supports simple properties");
		}
		else if (path.indexOf('=') > -1) {
			throw new IllegalArgumentException("This implementation only supports simple properties");
		}
		return;
	}

}
