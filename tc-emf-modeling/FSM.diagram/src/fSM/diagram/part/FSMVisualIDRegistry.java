package fSM.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class FSMVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "FSM.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (fSM.diagram.edit.parts.FSMEditPart.MODEL_ID.equals(view.getType())) {
				return fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return fSM.diagram.part.FSMVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	* @generated
	*/
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	* @generated
	*/
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				fSM.diagram.part.FSMDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	* @generated
	*/
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (fSM.FSMPackage.eINSTANCE.getFSM().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((fSM.FSM) domainElement)) {
			return fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = fSM.diagram.part.FSMVisualIDRegistry.getModelID(containerView);
		if (!fSM.diagram.edit.parts.FSMEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (fSM.diagram.edit.parts.FSMEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = fSM.diagram.part.FSMVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID:
			if (fSM.FSMPackage.eINSTANCE.getState().isSuperTypeOf(domainElement.eClass())) {
				return fSM.diagram.edit.parts.StateEditPart.VISUAL_ID;
			}
			if (fSM.FSMPackage.eINSTANCE.getEvent().isSuperTypeOf(domainElement.eClass())) {
				return fSM.diagram.edit.parts.EventEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = fSM.diagram.part.FSMVisualIDRegistry.getModelID(containerView);
		if (!fSM.diagram.edit.parts.FSMEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (fSM.diagram.edit.parts.FSMEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = fSM.diagram.part.FSMVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID:
			if (fSM.diagram.edit.parts.StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (fSM.diagram.edit.parts.EventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case fSM.diagram.edit.parts.StateEditPart.VISUAL_ID:
			if (fSM.diagram.edit.parts.StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case fSM.diagram.edit.parts.EventEditPart.VISUAL_ID:
			if (fSM.diagram.edit.parts.EventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			if (fSM.diagram.edit.parts.TransitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (fSM.FSMPackage.eINSTANCE.getTransition().isSuperTypeOf(domainElement.eClass())) {
			return fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(fSM.FSM element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	* @generated
	*/
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID:
			return false;
		case fSM.diagram.edit.parts.StateEditPart.VISUAL_ID:
		case fSM.diagram.edit.parts.EventEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		* @generated
		*/

		public int getVisualID(View view) {
			return fSM.diagram.part.FSMVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/

		public String getModelID(View view) {
			return fSM.diagram.part.FSMVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return fSM.diagram.part.FSMVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return fSM.diagram.part.FSMVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/

		public boolean isCompartmentVisualID(int visualID) {
			return fSM.diagram.part.FSMVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/

		public boolean isSemanticLeafVisualID(int visualID) {
			return fSM.diagram.part.FSMVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
