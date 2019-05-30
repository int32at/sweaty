package at.int32.sweaty.ui.controls;

import org.eclipse.swt.internal.cocoa.NSView;
import org.eclipse.swt.internal.cocoa.SWTView;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;

import at.int32.sweaty.ui.Control;

public class Toolbar extends Widget<ToolBar> {

	public Toolbar(Control parent) {
		super(parent);
	}

	@Override
	public ToolBar getBaseControl(Composite parent, int style) {
		var toolbar = parent.getShell().getToolBar();

		fixToolbar(toolbar);

		return toolbar;
	}

	private void fixToolbar(ToolBar toolbar) {
		// this fixes a nullpointer exception because unfortunately the Toolbar
		// class searches for a NSToolbar instance and won't find one, because
		// it finds a NSTitlebarContainerView instead
		// so we fake a unified toolbar (kinda ...)
		NSView widget = (NSView) new SWTView().alloc();
		widget.init();
		toolbar.view = widget;

		NSView subWidget = (NSView) new SWTView().alloc();
		subWidget.init();
		widget.addSubview(subWidget);
	}
}
