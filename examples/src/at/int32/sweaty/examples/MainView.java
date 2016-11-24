package at.int32.sweaty.examples;

import at.int32.sweaty.examples.images.Images;
import at.int32.sweaty.ui.Colors;
import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Grid;
import at.int32.sweaty.ui.View;
import at.int32.sweaty.ui.controls.Toolbar;
import at.int32.sweaty.ui.controls.ToolbarItem;
import at.int32.sweaty.ui.controls.ToolbarItem.Type;

public class MainView extends View {

	public MainView(Control parent) {
		super(parent);
	}

	@Override
	public void onInit() {
		Grid root = new Grid(this).background(Colors.get(255, 255, 255));

		Toolbar tb = new Toolbar(root);

		new ToolbarItem(tb).image(Images.toolbarSave).text("Save");
		new ToolbarItem(tb, Type.SEPARATOR);
		new ToolbarItem(tb).image(Images.toolbarEdit).text("Edit");
		new ToolbarItem(tb).image(Images.toolbarDelete).text("Delete");
		new ToolbarItem(tb, Type.SEPARATOR);
	}

}
