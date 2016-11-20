package at.int32.sweaty.ui.controls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;

import at.int32.sweaty.ui.EventHandler;
import at.int32.sweaty.ui.Window;

public class Toolbar extends Widget<org.eclipse.swt.widgets.ToolBar> {

	protected ToolBar raw;
	protected java.util.List<ToolbarItem> items = new ArrayList<>();

	public Toolbar(Window window) {
		super(window);
	}

	@Override
	public ToolBar getBaseControl(Composite parent) {
		raw = parent.getShell().getToolBar();

		return raw;
	}

	// public void addWidget(Control control, EventHandler onToolBarItemClicked)
	// {
	// ToolbarItem item = new ToolbarItem(this);
	// items.add(item);
	//
	// item.widget(control);
	// }

	public java.util.List<ToolbarItem> getToolbarItems() {
		return (List<ToolbarItem>) Collections.unmodifiableCollection(items);
	}

	public void addButton(String text, Image image, EventHandler clickHandler) {
		ToolbarItem item = new ToolbarItem(this);
		items.add(item);

		item.text("Test");
		item.image(image);
		// item.
	}
}
