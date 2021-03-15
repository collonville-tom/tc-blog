package fSM.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
 * @generated
 */
public class FSMDiagramUpdater {

	/**
	* @generated
	*/
	public static List<fSM.diagram.part.FSMNodeDescriptor> getSemanticChildren(View view) {
		switch (fSM.diagram.part.FSMVisualIDRegistry.getVisualID(view)) {
		case fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID:
			return getFSM_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<fSM.diagram.part.FSMNodeDescriptor> getFSM_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		fSM.FSM modelElement = (fSM.FSM) view.getElement();
		LinkedList<fSM.diagram.part.FSMNodeDescriptor> result = new LinkedList<fSM.diagram.part.FSMNodeDescriptor>();
		for (Iterator<?> it = modelElement.getState().iterator(); it.hasNext();) {
			fSM.State childElement = (fSM.State) it.next();
			int visualID = fSM.diagram.part.FSMVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == fSM.diagram.edit.parts.StateEditPart.VISUAL_ID) {
				result.add(new fSM.diagram.part.FSMNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getEvent().iterator(); it.hasNext();) {
			fSM.Event childElement = (fSM.Event) it.next();
			int visualID = fSM.diagram.part.FSMVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == fSM.diagram.edit.parts.EventEditPart.VISUAL_ID) {
				result.add(new fSM.diagram.part.FSMNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<fSM.diagram.part.FSMLinkDescriptor> getContainedLinks(View view) {
		switch (fSM.diagram.part.FSMVisualIDRegistry.getVisualID(view)) {
		case fSM.diagram.edit.parts.FSMEditPart.VISUAL_ID:
			return getFSM_1000ContainedLinks(view);
		case fSM.diagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001ContainedLinks(view);
		case fSM.diagram.edit.parts.EventEditPart.VISUAL_ID:
			return getEvent_2002ContainedLinks(view);
		case fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<fSM.diagram.part.FSMLinkDescriptor> getIncomingLinks(View view) {
		switch (fSM.diagram.part.FSMVisualIDRegistry.getVisualID(view)) {
		case fSM.diagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001IncomingLinks(view);
		case fSM.diagram.edit.parts.EventEditPart.VISUAL_ID:
			return getEvent_2002IncomingLinks(view);
		case fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<fSM.diagram.part.FSMLinkDescriptor> getOutgoingLinks(View view) {
		switch (fSM.diagram.part.FSMVisualIDRegistry.getVisualID(view)) {
		case fSM.diagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001OutgoingLinks(view);
		case fSM.diagram.edit.parts.EventEditPart.VISUAL_ID:
			return getEvent_2002OutgoingLinks(view);
		case fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getFSM_1000ContainedLinks(View view) {
		fSM.FSM modelElement = (fSM.FSM) view.getElement();
		LinkedList<fSM.diagram.part.FSMLinkDescriptor> result = new LinkedList<fSM.diagram.part.FSMLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getState_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getEvent_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getTransition_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getState_2001IncomingLinks(View view) {
		fSM.State modelElement = (fSM.State) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<fSM.diagram.part.FSMLinkDescriptor> result = new LinkedList<fSM.diagram.part.FSMLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getEvent_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getTransition_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getState_2001OutgoingLinks(View view) {
		fSM.State modelElement = (fSM.State) view.getElement();
		LinkedList<fSM.diagram.part.FSMLinkDescriptor> result = new LinkedList<fSM.diagram.part.FSMLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getEvent_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<fSM.diagram.part.FSMLinkDescriptor> getTransition_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<fSM.diagram.part.FSMLinkDescriptor> getContainedTypeModelFacetLinks_Transition_4001(
			fSM.FSM container) {
		LinkedList<fSM.diagram.part.FSMLinkDescriptor> result = new LinkedList<fSM.diagram.part.FSMLinkDescriptor>();
		for (Iterator<?> links = container.getTransition().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof fSM.Transition) {
				continue;
			}
			fSM.Transition link = (fSM.Transition) linkObject;
			if (fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID != fSM.diagram.part.FSMVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			fSM.State dst = link.getOut();
			fSM.State src = link.getIn();
			result.add(new fSM.diagram.part.FSMLinkDescriptor(src, dst, link,
					fSM.diagram.providers.FSMElementTypes.Transition_4001,
					fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<fSM.diagram.part.FSMLinkDescriptor> getIncomingTypeModelFacetLinks_Transition_4001(
			fSM.State target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<fSM.diagram.part.FSMLinkDescriptor> result = new LinkedList<fSM.diagram.part.FSMLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != fSM.FSMPackage.eINSTANCE.getTransition_Out()
					|| false == setting.getEObject() instanceof fSM.Transition) {
				continue;
			}
			fSM.Transition link = (fSM.Transition) setting.getEObject();
			if (fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID != fSM.diagram.part.FSMVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			fSM.State src = link.getIn();
			result.add(new fSM.diagram.part.FSMLinkDescriptor(src, target, link,
					fSM.diagram.providers.FSMElementTypes.Transition_4001,
					fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<fSM.diagram.part.FSMLinkDescriptor> getOutgoingTypeModelFacetLinks_Transition_4001(
			fSM.State source) {
		fSM.FSM container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof fSM.FSM) {
				container = (fSM.FSM) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<fSM.diagram.part.FSMLinkDescriptor> result = new LinkedList<fSM.diagram.part.FSMLinkDescriptor>();
		for (Iterator<?> links = container.getTransition().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof fSM.Transition) {
				continue;
			}
			fSM.Transition link = (fSM.Transition) linkObject;
			if (fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID != fSM.diagram.part.FSMVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			fSM.State dst = link.getOut();
			fSM.State src = link.getIn();
			if (src != source) {
				continue;
			}
			result.add(new fSM.diagram.part.FSMLinkDescriptor(src, dst, link,
					fSM.diagram.providers.FSMElementTypes.Transition_4001,
					fSM.diagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/

		public List<fSM.diagram.part.FSMNodeDescriptor> getSemanticChildren(View view) {
			return FSMDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/

		public List<fSM.diagram.part.FSMLinkDescriptor> getContainedLinks(View view) {
			return FSMDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/

		public List<fSM.diagram.part.FSMLinkDescriptor> getIncomingLinks(View view) {
			return FSMDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/

		public List<fSM.diagram.part.FSMLinkDescriptor> getOutgoingLinks(View view) {
			return FSMDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
