package fSM.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class FSMNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		fSM.diagram.part.FSMDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		fSM.diagram.part.FSMDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof fSM.diagram.navigator.FSMNavigatorItem
				&& !isOwnView(((fSM.diagram.navigator.FSMNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof fSM.diagram.navigator.FSMNavigatorGroup) {
			fSM.diagram.navigator.FSMNavigatorGroup group = (fSM.diagram.navigator.FSMNavigatorGroup) element;
			return fSM.diagram.part.FSMDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof fSM.diagram.navigator.FSMNavigatorItem) {
			fSM.diagram.navigator.FSMNavigatorItem navigatorItem = (fSM.diagram.navigator.FSMNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (fSM.diagram.part.FSMVisualIDRegistry.getVisualID(view)) {
		case fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.example.org/fSM?FSM", //$NON-NLS-1$
					fSM.diagram.providers.FSMElementTypes.FSM_1000);
		case fSM.diagram.edit.parts.StateEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/fSM?State", //$NON-NLS-1$
					fSM.diagram.providers.FSMElementTypes.State_2001);
		case fSM.diagram.edit.parts.EventEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/fSM?Event", //$NON-NLS-1$
					fSM.diagram.providers.FSMElementTypes.Event_2002);
		case fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/fSM?Transition", //$NON-NLS-1$
					fSM.diagram.providers.FSMElementTypes.Transition_4001);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = fSM.diagram.part.FSMDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& fSM.diagram.providers.FSMElementTypes.isKnownElementType(elementType)) {
			image = fSM.diagram.providers.FSMElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof fSM.diagram.navigator.FSMNavigatorGroup) {
			fSM.diagram.navigator.FSMNavigatorGroup group = (fSM.diagram.navigator.FSMNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof fSM.diagram.navigator.FSMNavigatorItem) {
			fSM.diagram.navigator.FSMNavigatorItem navigatorItem = (fSM.diagram.navigator.FSMNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (fSM.diagram.part.FSMVisualIDRegistry.getVisualID(view)) {
		case fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID:
			return getFSM_1000Text(view);
		case fSM.diagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001Text(view);
		case fSM.diagram.edit.parts.EventEditPart.VISUAL_ID:
			return getEvent_2002Text(view);
		case fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getFSM_1000Text(View view) {
		fSM.FSM domainModelElement = (fSM.FSM) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			fSM.diagram.part.FSMDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getState_2001Text(View view) {
		IParser parser = fSM.diagram.providers.FSMParserProvider.getParser(
				fSM.diagram.providers.FSMElementTypes.State_2001, view.getElement() != null ? view.getElement() : view,
				fSM.diagram.part.FSMVisualIDRegistry.getType(fSM.diagram.edit.parts.StateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			fSM.diagram.part.FSMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEvent_2002Text(View view) {
		IParser parser = fSM.diagram.providers.FSMParserProvider.getParser(
				fSM.diagram.providers.FSMElementTypes.Event_2002, view.getElement() != null ? view.getElement() : view,
				fSM.diagram.part.FSMVisualIDRegistry.getType(fSM.diagram.edit.parts.EventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			fSM.diagram.part.FSMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTransition_4001Text(View view) {
		IParser parser = fSM.diagram.providers.FSMParserProvider.getParser(
				fSM.diagram.providers.FSMElementTypes.Transition_4001,
				view.getElement() != null ? view.getElement() : view,
				fSM.diagram.part.FSMVisualIDRegistry.getType(fSM.diagram.edit.parts.TransitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			fSM.diagram.part.FSMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return fSM.diagram.edit.parts.FSMEditPart.MODEL_ID
				.equals(fSM.diagram.part.FSMVisualIDRegistry.getModelID(view));
	}

}
