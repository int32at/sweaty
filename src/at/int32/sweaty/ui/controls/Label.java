package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import at.int32.sweaty.ui.Control;

public class Label extends Widget<org.eclipse.swt.widgets.Label> {

	private String prefix = "", postfix = "";

	public Label(Control parent) {
		this(parent, SWT.NONE);
	}
	
	public Label(Control parent, int style){
		super(parent, style);
	}

	public Label image(Image img) {
		ctrl.setImage(img);
		return this;
	}

	public Label prefix(String text) {
		this.prefix = text;
		return this;
	}

	public Label postfix(String text) {
		this.postfix = text;
		return this;
	}

	public Label text(String text) {
		if (text == null)
			return this;
		String fullText = !prefix.isEmpty() ? prefix + text : text;
		this.ctrl.setText(fullText + postfix);
		return this;
	}

	public Label text(Integer text) {
		return text(text.toString());
	}

	public Label size(int fontSize) {
		FontData[] fD = ctrl.getFont().getFontData();
		fD[0].setHeight(fontSize);
		ctrl.setFont(new Font(Display.getCurrent(), fD[0]));
		return this;
	}

	public Label foreground(Color color) {
		this.ctrl.setForeground(color);
		return this;
	}

	@Override
	public Label center() {
		return (Label) super.center();
	}

	@Override
	public Label visible(boolean visible) {
		return (Label) super.visible(visible);
	}

	@Override
	public Label handCursor() {
		return (Label) super.handCursor();
	}

	@Override
	public org.eclipse.swt.widgets.Label getBaseControl(Composite parent,
			int style) {
		return new org.eclipse.swt.widgets.Label(parent, style);
	}
}
