package at.int32.sweaty.ui.controls;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;

import at.int32.sweaty.OS;
import at.int32.sweaty.ui.Control;

public class Toolbar extends Widget<ToolBar> {

	public Toolbar(Control parent) {
		super(parent);
	}

	@Override
	public ToolBar getBaseControl(Composite parent, int style) {
		return parent.getShell().getToolBar();
	}

	public void setTitleVisible(boolean visible) {
		OS.MacOS.setWindowTitleVisible(parent().view.window(), visible);
	}
}
