package at.int32.sweaty.ui;

import org.eclipse.swt.widgets.Composite;

public abstract class View extends Control {

	public View(Control parent) {
		create(parent.ctrl());
	}

	@Override
	public Composite onCreate() {
		return createDefaultComposite();
	}

}
