package at.int32.sweaty.ui.utils;

import java.io.InputStream;

public class ResourceLoader {

	public static InputStream load(String path) {
		return ClassLoader.getSystemResourceAsStream("at/lineapp/desktop/resources/" + path);
	}
	
	public static InputStream image(String path) {
		return load("images/" + path);
	}
}