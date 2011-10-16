package ch.vorburger.blueprints.data;

import java.util.LinkedList;
import java.util.List;

import commonj.sdo.DataObject;

/**
 * DataObjectFactory which internally tries different registered other DataObjectFactories.
 *
 * @author Michael Vorburger
 */
public class ChainedDataObjectFactory implements DataObjectFactory {

	private final List<DataObjectFactory> list = new LinkedList<DataObjectFactory>();  
	
	public void register(DataObjectFactory dataObjectFactory) {
		list.add(dataObjectFactory);
	}
	
	@Override
	public DataObject create(String nsURI, String typeName) {
		for (DataObjectFactory dataObjectFactory : list) {
			DataObject dataObject = dataObjectFactory.create(nsURI, typeName);
			if (dataObject != null) {
				return dataObject;
			}
		}
		return null;
	}

//	@Override
//	public <T> T create(Class<T> klass) {
//		for (DataObjectFactory dataObjectFactory : list) {
//			T dataObject = dataObjectFactory.create(klass);
//			if (dataObject != null) {
//				return dataObject;
//			}
//		}
//		return null;
//	}

}
