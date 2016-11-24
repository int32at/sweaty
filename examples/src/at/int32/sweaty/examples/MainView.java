package at.int32.sweaty.examples;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.View;
import at.int32.sweaty.ui.controls.Label;

public class MainView extends View {

	public MainView(Control parent) {
		super(parent);
	}

	@Override
	public void onInit() {
		new Label(this).text("Example 1").center();
	}

}
