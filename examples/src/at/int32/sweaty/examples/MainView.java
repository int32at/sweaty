package at.int32.sweaty.examples;

import at.int32.sweaty.examples.images.Images;
import at.int32.sweaty.ui.Colors;
import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Grid;
import at.int32.sweaty.ui.View;
import at.int32.sweaty.ui.annotations.OnClick;
import at.int32.sweaty.ui.annotations.OnClickEvent;
import at.int32.sweaty.ui.controls.Toolbar;
import at.int32.sweaty.ui.controls.ToolbarItem;
import at.int32.sweaty.ui.controls.ToolbarItem.Type;
import at.int32.sweaty.ui.controls.Tray;

public class MainView extends View {

	public MainView(Control parent) {
		super(parent);
	}
	
	private ToolbarItem save, edit, delete;

	@Override
	public void onInit() {
		Grid root = new Grid(this).background(Colors.get(255, 255, 255));

		// create tray icon
		new Tray(root).image(Images.trayIcon).click(this);

		// create toolbar
		Toolbar tb = new Toolbar(root);

		save = new ToolbarItem(tb).image(Images.toolbarSave).text("Save").click(this);
		edit = new ToolbarItem(tb).image(Images.toolbarEdit).text("Edit").click(this);
		delete = new ToolbarItem(tb).image(Images.toolbarDelete).text("Delete").click(this);
		new ToolbarItem(tb, Type.SEPARATOR);
	}
	
	@OnClick
	public void onClick(OnClickEvent e) {
		System.out.println("clicked control = " + e.source());
	}

}
