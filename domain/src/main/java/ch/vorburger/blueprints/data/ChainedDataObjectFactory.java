package ch.vorburger.blueprints.data;

import java.util.LinkedList;
import java.util.List;

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
	public DataObject create(String typeURI) {
		for (DataObjectFactory dataObjectFactory : list) {
			DataObject dataObject = dataObjectFactory.create(typeURI);
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
