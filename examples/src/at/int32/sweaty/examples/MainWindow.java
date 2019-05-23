package at.int32.sweaty.examples;

import at.int32.sweaty.ui.Window;

public class MainWindow extends Window {

	@Override
	public void onInit() {
		new MainView(this);
	}

	@Override
	public void onExit() {
		System.exit(0);
	}

}
