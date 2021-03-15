
package fSM.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

/**
 * @generated
 */
public class FSMPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createFSM1Group());
	}

	/**
	* Creates "fSM" palette tool group
	* @generated
	*/
	private PaletteContainer createFSM1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(fSM.diagram.part.Messages.FSM1Group_title);
		paletteContainer.setId("createFSM1Group"); //$NON-NLS-1$
		paletteContainer.add(createState1CreationTool());
		paletteContainer.add(createTransition2CreationTool());
		paletteContainer.add(createEvent3CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createState1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(fSM.diagram.part.Messages.State1CreationTool_title,
				fSM.diagram.part.Messages.State1CreationTool_desc,
				Collections.singletonList(fSM.diagram.providers.FSMElementTypes.State_2001));
		entry.setId("createState1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(fSM.diagram.providers.FSMElementTypes
				.getImageDescriptor(fSM.diagram.providers.FSMElementTypes.State_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTransition2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(fSM.diagram.part.Messages.Transition2CreationTool_title,
				fSM.diagram.part.Messages.Transition2CreationTool_desc,
				Collections.singletonList(fSM.diagram.providers.FSMElementTypes.Transition_4001));
		entry.setId("createTransition2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(fSM.diagram.providers.FSMElementTypes
				.getImageDescriptor(fSM.diagram.providers.FSMElementTypes.Transition_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEvent3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(fSM.diagram.part.Messages.Event3CreationTool_title,
				fSM.diagram.part.Messages.Event3CreationTool_desc,
				Collections.singletonList(fSM.diagram.providers.FSMElementTypes.Event_2002));
		entry.setId("createEvent3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(fSM.diagram.providers.FSMElementTypes
				.getImageDescriptor(fSM.diagram.providers.FSMElementTypes.Event_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
