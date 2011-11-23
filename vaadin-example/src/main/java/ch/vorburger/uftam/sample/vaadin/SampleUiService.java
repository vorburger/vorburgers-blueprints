package ch.vorburger.uftam.sample.vaadin;

import ch.vorburger.blueprints.dyna.access.PropertyAccessorService;
import ch.vorburger.blueprints.dyna.binding.SimpleBinding;
import ch.vorburger.uftam.sample.vaadin.smartform.SampleFormView;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public class SampleUiService implements UiService<SampleFormView> {

	SimpleBinding b;
	PropertyAccessorService s;
	
	@Override
	public void invoke(SampleFormView uiModel) {
		//b.mapFromTo(dataObjectNameMap) ...
		Object bean = null;
		
		// uiModel.getTextField_amount()
		uiModel.getPopupDateField().setEnabled((Double)s.getPropertyValue(bean, "amount") > 1000);

		
	}

}
