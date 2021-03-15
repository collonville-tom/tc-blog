package fSM.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class TransitionItemSemanticEditPolicy extends fSM.diagram.edit.policies.FSMBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public TransitionItemSemanticEditPolicy() {
		super(fSM.diagram.providers.FSMElementTypes.Transition_4001);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
