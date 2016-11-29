package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.annotations.OnClick;
import at.int32.sweaty.ui.annotations.OnClickEvent;
import at.int32.sweaty.ui.annotations.OnToggle;
import at.int32.sweaty.ui.annotations.OnToggleEvent;

public class ToggleButton extends Widget<org.eclipse.swt.widgets.Label> {

	protected boolean checked = false;
	private Image on, off;

	public ToggleButton(Control parent) {
		this(parent, SWT.NONE);
	}
	
	public ToggleButton(Control parent, int style) {
		super(parent, style);
		this.click(this);
	}

	public ToggleButton image(Image img) {
		ctrl.setImage(img);
		return this;
	}

	public ToggleButton on(Image img) {
		on = img;
		return this;
	}

	public ToggleButton off(Image img) {
		off = img;
		return this;
	}

	public ToggleButton on() {
		checked = true;
		image(on);
		return this;
	}

	public ToggleButton off() {
		checked = false;
		image(off);
		return this;
	}

	public ToggleButton toggle(Object o) {
		events.register(OnToggle.class, o);
		return this;
	}

	@Override
	public ToggleButton center() {
		return (ToggleButton) super.center();
	}
	
	public boolean checked() {
		return checked;
	}

	@Override
	public org.eclipse.swt.widgets.Label getBaseControl(Composite parent, int style) {
		return new org.eclipse.swt.widgets.Label(parent, style);
	}

	@OnClick
	public void onClick(OnClickEvent e) {
		checked = !checked;
		image(checked ? on : off);
		events.post(OnToggle.class, new OnToggleEvent(this, checked));
	}
}
