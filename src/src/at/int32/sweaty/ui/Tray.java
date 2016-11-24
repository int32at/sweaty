package at.int32.sweaty.ui;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import at.int32.sweaty.ui.controls.Widget;

public class Tray extends Widget<org.eclipse.swt.widgets.TrayItem> {

	public Tray(Control parent) {
		super(parent);
	}

	@Override
	public org.eclipse.swt.widgets.TrayItem getBaseControl(Composite parent,
			int style) {
		return new org.eclipse.swt.widgets.TrayItem(Display.getDefault()
				.getSystemTray(), style);
	}

	public Tray image(Image img) {
		this.ctrl.setImage(img);
		return this;
	}

}
