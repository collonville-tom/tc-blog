package fSM.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class FSMModelingAssistantProviderOfFSMEditPart extends fSM.diagram.providers.FSMModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(fSM.diagram.providers.FSMElementTypes.State_2001);
		types.add(fSM.diagram.providers.FSMElementTypes.Event_2002);
		return types;
	}

}
