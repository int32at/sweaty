package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;

public abstract class Widget<T extends org.eclipse.swt.widgets.Control> extends Control {
	
	public abstract T getBaseControl(Composite parent);
	protected T ctrl;
	
	public Widget(Control parent) {
		create(parent.ctrl());
	}

	@Override
	public void onInit() {
	}
	
	public Widget<T> center() {
		data().horizontalAlignment = SWT.CENTER;
		return this;
	}
	
	public Widget<T> right() {
		data().horizontalAlignment = SWT.RIGHT;
		return this;
	}
	
	public Widget<T> left() {
		data().horizontalAlignment = SWT.LEFT;
		return this;
	}

	@Override
	public Composite onCreate() {
		Composite wrapper = createDefaultComposite();
		this.ctrl = getBaseControl(wrapper);
		return wrapper;
	}
}
