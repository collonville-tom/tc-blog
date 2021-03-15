package fSM.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	* @generated
	*/
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		fSM.diagram.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		fSM.diagram.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		fSM.diagram.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		fSM.diagram.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		fSM.diagram.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);

	}

	/**
	* @generated
	*/
	protected IPreferenceStore getPreferenceStore() {
		return fSM.diagram.part.FSMDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
