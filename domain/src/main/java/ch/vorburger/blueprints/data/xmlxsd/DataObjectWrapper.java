package ch.vorburger.blueprints.data.xmlxsd;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import ch.vorburger.blueprints.data.DataObject;
import ch.vorburger.blueprints.data.DataObjectImplUtil;

/**
 * Wraps a SDO DataObject to make it implement our (simplified) DataObject interface.
 *
 * @author Michael Vorburger
 */
/* package-local */
class DataObjectWrapper implements DataObject {
	private static final long serialVersionUID = -718554191149674101L;
	
	private final commonj.sdo.DataObject sdoDataObject;

	// TODO This doesn't handle contained DataObjects yet!
	
	public DataObjectWrapper(commonj.sdo.DataObject sdoDO) {
		this.sdoDataObject = sdoDO;
	}

	@Override
	public Object get(String path) {
		DataObjectImplUtil.checkPath(path);
		return sdoDataObject.get(path.replace('.', '/'));
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(String path, Class<T> type) {
		DataObjectImplUtil.checkPath(path);
		if (type.equals(String.class))
			return (T) sdoDataObject.getString(path.replace('.', '/'));
		else if (type.equals(Boolean.class))
			return (T) Boolean.valueOf(sdoDataObject.getBoolean(path.replace('.', '/')));
		else if (type.equals(BigDecimal.class))
			return (T) sdoDataObject.getBigDecimal(path.replace('.', '/'));
		else if (type.equals(Date.class))
			return (T) sdoDataObject.getDate(path.replace('.', '/'));
		else if (type.equals(Double.class))
			return (T) Double.valueOf(sdoDataObject.getDouble(path.replace('.', '/')));
		else if (type.equals(Float.class))
			return (T) Float.valueOf(sdoDataObject.getFloat(path.replace('.', '/')));
		else if (type.equals(Long.class))
			return (T) Long.valueOf(sdoDataObject.getLong(path.replace('.', '/')));
		else if (type.equals(Integer.class))
			return (T) Integer.valueOf(sdoDataObject.getInt(path.replace('.', '/')));
		else if (type.equals(Character.class))
			return (T) Character.valueOf(sdoDataObject.getChar(path.replace('.', '/')));
		else if (type.equals(BigInteger.class))
			return (T) sdoDataObject.getBigInteger(path.replace('.', '/'));
		else if (type.equals(Byte.class))
			return (T) Byte.valueOf(sdoDataObject.getByte(path.replace('.', '/')));
		else if (type.equals(Short.class))
			return (T) Short.valueOf(sdoDataObject.getShort(path.replace('.', '/')));
		// TODO Must handle List and DataObject as well! List needs to convert contained DataObject (if they are that)..
		else
			throw new IllegalArgumentException("SDO API does not support strongly typed getter for Class " + type.getName());
	}

	@Override
	public void set(String path, Object value) {
		DataObjectImplUtil.checkPath(path);
		sdoDataObject.set(path.replace('.', '/'), value);
	}

}
