package at.int32.sweaty;

public class OS {
	public static boolean isMac() {
		return System.getProperty("os.name").toLowerCase().trim().indexOf("mac") >= 0;
	}
	
	public static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().trim().indexOf("windows") >= 0;
	}
}
