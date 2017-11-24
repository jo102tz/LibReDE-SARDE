package tools.descartes.librede.rrde.model.editor.util;

import org.eclipse.jface.viewers.LabelProvider;

import tools.descartes.librede.registry.Registry;

public class OptAlgorithmLabelProvider extends LabelProvider {	

		@Override
		public String getText(Object element) {
			return Registry.INSTANCE.getDisplayName(Registry.INSTANCE.getInstanceClass((String) element));
		}
	
}
