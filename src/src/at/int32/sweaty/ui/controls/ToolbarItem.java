package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import at.int32.sweaty.ui.annotations.OnClick;
import at.int32.sweaty.ui.annotations.OnClickEvent;
import at.int32.sweaty.ui.controls.events.ClickBehaviour.ClickType;

public class ToolbarItem extends Widget<ToolItem> {

	public enum Type {
		NORMAL, SEPARATOR
	}

	public ToolbarItem(Toolbar parent) {
		this(parent, Type.NORMAL);
	}

	public ToolbarItem(Toolbar parent, Type type) {
		super(parent, getToolbarStyleBit(type));
		this.ctrl.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				events.post(OnClick.class, new OnClickEvent(ToolbarItem.this,
						ClickType.SINGLE));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
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

	@Override
	public ToolbarItem click(Object o) {
		return (ToolbarItem) super.click(o);
	}
	
	@Override
	public String toString() {
		return super.toString() + "(" + text() + ")";
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
