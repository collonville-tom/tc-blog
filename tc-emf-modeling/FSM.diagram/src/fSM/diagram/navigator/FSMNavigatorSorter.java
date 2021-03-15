package fSM.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class FSMNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 4003;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof fSM.diagram.navigator.FSMNavigatorItem) {
			fSM.diagram.navigator.FSMNavigatorItem item = (fSM.diagram.navigator.FSMNavigatorItem) element;
			return fSM.diagram.part.FSMVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
