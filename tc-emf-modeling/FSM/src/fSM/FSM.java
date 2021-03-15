/**
 */
package fSM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fSM.FSM#getState <em>State</em>}</li>
 *   <li>{@link fSM.FSM#getTransition <em>Transition</em>}</li>
 *   <li>{@link fSM.FSM#getEvent <em>Event</em>}</li>
 * </ul>
 *
 * @see fSM.FSMPackage#getFSM()
 * @model
 * @generated
 */
public interface FSM extends NamedElement {
	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference list.
	 * The list contents are of type {@link fSM.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference list.
	 * @see fSM.FSMPackage#getFSM_State()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getState();

	/**
	 * Returns the value of the '<em><b>Transition</b></em>' containment reference list.
	 * The list contents are of type {@link fSM.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' containment reference list.
	 * @see fSM.FSMPackage#getFSM_Transition()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransition();

	/**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference list.
	 * The list contents are of type {@link fSM.Event}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' containment reference list.
	 * @see fSM.FSMPackage#getFSM_Event()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvent();

} // FSM
