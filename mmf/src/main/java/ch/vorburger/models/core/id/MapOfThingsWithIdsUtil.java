package ch.vorburger.models.core.id;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Util for MapOfThingsWithIds.
 *
 * @author Michael Vorburger
 */
public class MapOfThingsWithIdsUtil {

	public static <T_ID extends Id, T_TWID extends ThingWithId<T_ID>> MapOfThingsWithIds<T_ID, T_TWID> newMap() {
		return wrap(new LinkedHashMap<T_ID, T_TWID>());
	}
	
	public static <T_ID extends Id, T_TWID extends ThingWithId<T_ID>> MapOfThingsWithIds<T_ID, T_TWID> wrap(Map<T_ID, T_TWID> normalMap) {
		return new Wrapper<T_ID, T_TWID>(normalMap);
	}
	
	private static class Wrapper<T_ID extends Id, T_TWID extends ThingWithId<T_ID>> implements MapOfThingsWithIds<T_ID, T_TWID> {
		private final Map<T_ID, T_TWID> delegate;

		public Wrapper(Map<T_ID, T_TWID> normalMap) {
			this.delegate = normalMap;
		}

		@Override
		public void put(T_TWID somethingWithId) {
			if (somethingWithId == null) {
				throw new IllegalArgumentException("null argument not allowed");
			}
			delegate.put(somethingWithId._id(), somethingWithId);
		}
		
		@Override
		public int size() {
			return delegate.size();
		}

		@Override
		public boolean isEmpty() {
			return delegate.isEmpty();
		}

		@Override
		public boolean containsKey(Object key) {
			if (key == null) {
				throw new IllegalArgumentException("null argument not allowed");
			}
			return delegate.containsKey(key);
		}

		@Override
		public boolean containsValue(Object value) {
			if (value == null) {
				throw new IllegalArgumentException("null argument not allowed");
			}
			return delegate.containsValue(value);
		}

		@Override
		public T_TWID get(Object key) {
			if (key == null) {
				throw new IllegalArgumentException("null argument not allowed");
			}
			if (!(key instanceof Id)) {
				throw new IllegalArgumentException("argument is not an Id");
			}
			Id id = (Id) key;
			
			T_TWID value = delegate.get(id);
			if (value == null) {
				throw new IllegalArgumentException("Not found: " + id.toString());
			}
			return value;
		}

		@Override
		public T_TWID put(T_ID key, T_TWID value) {
			if (key == null || value == null) {
				throw new IllegalArgumentException("null argument not allowed");
			}
			return delegate.put(key, value);
		}

		@Override
		public T_TWID remove(Object key) {
			if (key == null) {
				throw new IllegalArgumentException("null argument not allowed");
			}
			return delegate.remove(key);
		}

		@Override
		public void putAll(Map<? extends T_ID, ? extends T_TWID> m) {
			if (m == null) {
				throw new IllegalArgumentException("null argument not allowed");
			}
			delegate.putAll(m);
		}

		@Override
		public void clear() {
			delegate.clear();
		}

		@Override
		public Set<T_ID> keySet() {
			return delegate.keySet();
		}

		@Override
		public Collection<T_TWID> values() {
			return delegate.values();
		}

		@Override
		public Set<java.util.Map.Entry<T_ID, T_TWID>> entrySet() {
			return delegate.entrySet();
		}

		@Override
		public boolean equals(Object o) {
			return delegate.equals(o);
		}

		@Override
		public int hashCode() {
			return delegate.hashCode();
		}
	}
}
