package at.int32.sweaty.ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class Colors {
	public static Color get(int r, int g, int b) {
		return new Color(Display.getDefault(), r, g, b);
	}
}
