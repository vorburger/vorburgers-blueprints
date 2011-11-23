package ch.vorburger.uftam.sample.vaadin;

import com.vaadin.ui.ComponentContainer;

/**
 * TODO Doc
 *
 * @author Michael Vorburger
 */
public interface UiService<T extends ComponentContainer>  {
	
	// TODO Signature? ComponentContainer.. or just Object?  ComponentContainer clearer, for now.
	void invoke(T uiModel);

}
