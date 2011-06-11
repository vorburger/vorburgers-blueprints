package ch.vorburger.blueprint.interactionframework.odata;

import org.odata4j.core.OEntity;
import org.odata4j.core.OEntityKey;
import org.odata4j.edm.EdmDataServices;
import org.odata4j.producer.BaseResponse;
import org.odata4j.producer.EntitiesResponse;
import org.odata4j.producer.EntityResponse;
import org.odata4j.producer.ODataProducer;
import org.odata4j.producer.QueryInfo;

public abstract class AbstractInteractionFrameworkODataProducerImpl implements ODataProducer {

	public AbstractInteractionFrameworkODataProducerImpl() {
		// TODO Auto-generated constructor stub
	}

	public EdmDataServices getMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntitiesResponse getEntities(String entitySetName, QueryInfo queryInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityResponse getEntity(String entitySetName, OEntityKey entityKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResponse getNavProperty(String entitySetName, OEntityKey entityKey, String navProp, QueryInfo queryInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public EntityResponse createEntity(String entitySetName, OEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityResponse createEntity(String entitySetName, OEntityKey entityKey, String navProp, OEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEntity(String entitySetName, OEntityKey entityKey) {
		// TODO Auto-generated method stub

	}

	public void mergeEntity(String entitySetName, OEntity entity) {
		// TODO Auto-generated method stub

	}

	public void updateEntity(String entitySetName, OEntity entity) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
