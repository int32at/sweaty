package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import at.int32.sweaty.ui.Control;

public class Button extends Widget<org.eclipse.swt.widgets.Button> {

	public Button(Control parent) {
		super(parent);
	}

	public Button text(String text) {
		this.ctrl.setText(text);
		return this;
	}

	public Button foreground(Color color) {
		this.ctrl.setForeground(color);
		return this;
	}
	
	public Button size(int width, int height) {
		this.ctrl.setSize(width, height);
		return this;
	}

	public Button fontSize(int fontSize) {
		FontData[] fD = ctrl.getFont().getFontData();
		fD[0].setHeight(fontSize);
		ctrl.setFont(new Font(Display.getCurrent(), fD[0]));
		return this;
	}

	@Override
	public Button center() {
		return (Button) super.center();
	}

	@Override
	public Button handCursor() {
		return (Button) super.handCursor();
	}

	@Override
	public org.eclipse.swt.widgets.Button getBaseControl(Composite parent,
			int style) {
		return new org.eclipse.swt.widgets.Button(parent, SWT.PUSH);
	}

}
