package at.int32.sweaty;

import org.eclipse.swt.internal.cocoa.NSWindow;

public class OS {
	private static Long titleVisibilitySelector;

	public static boolean isMac() {
		return System.getProperty("os.name").toLowerCase().trim().indexOf("mac") >= 0;
	}

	public static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().trim().indexOf("windows") >= 0;
	}

	public static class MacOS {
		public static void setWindowTitleVisible(NSWindow window, boolean visible) {
			if (titleVisibilitySelector == null) {
				titleVisibilitySelector = org.eclipse.swt.internal.cocoa.OS.sel_registerName("setTitleVisibility:");
			}

			org.eclipse.swt.internal.cocoa.OS.objc_msgSend(window.id, titleVisibilitySelector, visible ? 0 : 1);
		}
	}
}
