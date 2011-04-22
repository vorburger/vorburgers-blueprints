package ch.vorburger.models.core.id;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public abstract class IdImpl implements Id {

	private final String id;
	private Integer hashCode;
	
	public IdImpl(String... id) {
		if (id.length == 0) {
			throw new IllegalArgumentException("null ID");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < id.length; i++) {
			String string = id[i];
// TODO re-enable (?)			
//			if (string == null) {
//				throw new IllegalArgumentException("null ID");
//			}
			sb.append(':');
			sb.append(string);
		}
		this.id = sb.toString();
	}

	@Override
	public String toString() {
		return id;
	}

	@Override
	public int hashCode() {
		if (hashCode == null)
			hashCode = id.hashCode(); 
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdImpl other = (IdImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
