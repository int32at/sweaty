package at.int32.sweaty.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import at.int32.sweaty.ui.controls.Toolbar;

public abstract class Window extends Control {
	private Display display;
	private Shell shell;
	private Toolbar toolbar;

	public abstract void onExit();
	
	public Window(String appName) {
		Display.setAppName(appName);
		display = Display.getDefault();
		shell = new Shell();
	}

	@Override
	public Composite onCreate() {
		return new Composite(parent(), SWT.NONE);
	}

	public void centerOnScreen() {
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();

		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;

		shell.setLocation(x, y);
	}

	public void show() {
		create(shell);
		ctrl().setLayout(Layout.Grid.layout(1));
		ctrl().setLayoutData(Layout.Grid.data(0, true, true));

		setDefaultLayout();
		shell.open();
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		onExit();
	}

	public void hide() {
		if (display != null)
			display.dispose();
	}

	public Composite raw() {
		return shell;
	}

	public void setTitle(String text) {
		shell.setText(text);
	}

	public void setSize(int x, int y) {
		shell.setSize(x, y);
	}

	public void setAppImage(Image img) {
		shell.setImage(img);
	}

	private void setDefaultLayout() {
		GridLayout layout = new GridLayout(1, false);
		layout.makeColumnsEqualWidth = true;
		layout.marginBottom = 0;
		layout.marginTop = 0;
		layout.marginLeft = 0;
		layout.marginRight = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		layout.marginHeight = 0;

		shell.setLayout(layout);
	}

	public Toolbar createToolbar() {
		this.toolbar = new Toolbar(this);
		return this.toolbar;
	}
}
