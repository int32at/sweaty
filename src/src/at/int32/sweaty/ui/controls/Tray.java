package at.int32.sweaty.ui.controls;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TrayItem;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.annotations.OnClick;
import at.int32.sweaty.ui.annotations.OnClickEvent;
import at.int32.sweaty.ui.controls.events.ClickBehaviour.ClickType;

public class Tray extends Widget<org.eclipse.swt.widgets.TrayItem> {

	public Tray(Control parent) {
		super(parent);
		this.ctrl.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				events.post(OnClick.class, new OnClickEvent(Tray.this,
						ClickType.SINGLE));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}

	@Override
	public org.eclipse.swt.widgets.TrayItem getBaseControl(Composite parent,
			int style) {
		return new org.eclipse.swt.widgets.TrayItem(Display.getDefault()
				.getSystemTray(), style);
	}

	public Tray tooltip(String text) {
		this.ctrl.setText(text);
		return this;
	}

	public Tray image(Image img) {
		this.ctrl.setImage(img);
		return this;
	}

	@Override
	public Tray click(Object o) {
		return (Tray) super.click(o);
	}
}
