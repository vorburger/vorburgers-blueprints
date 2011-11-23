package ch.vorburger.blueprints.data;

import java.util.LinkedList;
import java.util.List;

import ch.vorburger.blueprints.data.meta.Type;
import ch.vorburger.blueprints.objects.ObjectFactoryException;

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
	public DataObject create(String typeURI) throws ObjectFactoryException {
		for (DataObjectFactory dataObjectFactory : list) {
			DataObject dataObject = dataObjectFactory.create(typeURI);
			if (dataObject != null) {
				return dataObject;
			}
		}
		return null;
	}

	@Override
	public DataObject create(Type type) throws ObjectFactoryException {
		for (DataObjectFactory dataObjectFactory : list) {
			DataObject dataObject = dataObjectFactory.create(type);
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
