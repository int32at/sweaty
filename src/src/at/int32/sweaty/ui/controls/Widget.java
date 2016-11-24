package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;

public abstract class Widget<T extends org.eclipse.swt.widgets.Widget> extends Control {
	
	public abstract T getBaseControl(Composite parent, int style);
	
	protected T ctrl;
	protected int style;
	
	public Widget(Control parent) {
		this(parent, -1);
	}
	
	public Widget(Control parent, int style) {
		this.style = style;
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
		this.ctrl = getBaseControl(wrapper, style);
		return wrapper;
	}
}
