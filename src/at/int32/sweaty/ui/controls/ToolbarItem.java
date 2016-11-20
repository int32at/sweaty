package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import at.int32.sweaty.ui.Control;

public class ToolbarItem extends Widget<org.eclipse.swt.widgets.ToolItem> {

	protected ToolItem raw;
	protected Control control;

	public ToolbarItem(Toolbar parent) {
		super(parent);
	}

	// protected void setup(Control control, EventHandler onToolBarItemClicked)
	// {
	// final ToolbarItem self = this;
	//
	// raw.setControl(control.parent());
	// raw.addSelectionListener(new SelectionListener() {
	// @Override
	// public void widgetSelected(SelectionEvent paramSelectionEvent) {
	// onToolBarItemClicked.onEvent(paramSelectionEvent, self);
	// }
	//
	// @Override
	// public void widgetDefaultSelected(SelectionEvent paramSelectionEvent) {
	// }
	// });
	// }

	@Override
	public ToolItem getBaseControl(Composite parent) {
		this.raw = new ToolItem((ToolBar) parent.getShell().getToolBar(), SWT.PUSH);

		return raw;
	}

	public void text(String string) {
		ctrl.setText(string);
	}

	public void image(Image image) {
		ctrl.setImage(image);
	}
}
