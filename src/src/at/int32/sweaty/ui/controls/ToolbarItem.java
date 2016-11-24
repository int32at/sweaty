package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class ToolbarItem extends Widget<ToolItem> {

	public enum Type {
		NORMAL, SEPARATOR
	}

	private Type type;

	public ToolbarItem(Toolbar parent) {
		this(parent, Type.NORMAL);
	}

	public ToolbarItem(Toolbar parent, Type type) {
		super(parent, getToolbarStyleBit(type));
	}

	@Override
	public ToolItem getBaseControl(Composite parent, int style) {
		return new ToolItem((ToolBar) parent.getShell().getToolBar(), style);
	}

	public ToolbarItem text(String text) {
		this.ctrl.setText(text);
		return this;
	}
	
	public String text() {
		return this.ctrl.getText();
	}

	public ToolbarItem image(Image img) {
		this.ctrl.setImage(img);
		return this;
	}
	
	private static int getToolbarStyleBit(Type type) {
		switch (type) {
		case SEPARATOR:
			return SWT.SEPARATOR;
		default:
			return 0;
		}
	}

}
