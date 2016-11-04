package at.int32.sweaty.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import at.int32.sweaty.ui.controls.events.ClickBehaviour;
import at.int32.sweaty.ui.controls.events.ClickBehaviour.IOnClickListener;

public abstract class Control {

	private Composite parent;
	private Composite ctrl;

	public abstract void onInit();

	public abstract Composite onCreate();

	public void create(Composite parent) {
		this.parent = parent;
		this.ctrl = onCreate();
		this.ctrl.setBackgroundMode(SWT.INHERIT_FORCE);
		onInit();
	}
	
	public Composite parent() {
		return parent;
	}

	public Composite ctrl() {
		return ctrl;
	}

	public Control update() {
		ctrl.layout();
		parent().layout();
		return this;
	}
	
	public Control background(Color color) {
		ctrl().setBackground(color);
		return this;
	}
	
	public Control visible(boolean visible) {
		ctrl().setVisible(visible);
		return this;
	}
	
	public Control dispose() {
		ctrl().dispose();
		return this;
	}
	
	public Control handCursor() {
		ctrl().setCursor(new Cursor(Display.getDefault(), SWT.CURSOR_HAND));
		return this;
	}
	
	public Control normalCursor() {
		ctrl().setCursor(new Cursor(Display.getDefault(), SWT.CURSOR_ARROW));
		return this;
	}
	
	protected Composite createDefaultComposite() {
		Composite composite = new Composite(parent(), SWT.PUSH);
		composite.setLayout(Layout.Grid.layout(1));
		composite.setLayoutData(Layout.Grid.data(0, true, true));
		return composite;
	}
	
	protected GridData data() {
		return (GridData) ctrl().getLayoutData();
	}
	
	protected GridLayout layout() {
		return (GridLayout) ctrl().getLayout();
	}
	
	public Control click(IOnClickListener listener) {
		return click(listener, false);
	}
	
	public Control click(IOnClickListener listener, boolean propagateToChildren) {
		addMouseListener(ctrl, new ClickBehaviour(listener), propagateToChildren);
		return this;
	}
	
	private void addMouseListener(org.eclipse.swt.widgets.Control c, MouseListener ma, boolean propagateToChildren) {
	    c.addMouseListener(ma);
	    if (c instanceof Composite) {
	        for (final org.eclipse.swt.widgets.Control cc : ((Composite) c).getChildren()) {
	            addMouseListener(cc, ma, propagateToChildren);
	        }
	    }
	}
}
