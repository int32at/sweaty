package at.int32.sweaty.ui;

import org.eclipse.swt.widgets.Display;

public abstract class Application {

	public void setAppName(String appName) {
		Display.setAppName(appName);
	}

	public void setAppIcon() {
		// var application = com.apple.eawt.Application.getApplication();
		// application.setDockIconImage(ImageIO.read(Test.class.getResource("/javaapplication163/bunny.jpg")));

	}
}
