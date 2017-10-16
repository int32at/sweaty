package at.int32.sweaty.examples.images;

import org.eclipse.swt.graphics.Image;

import at.int32.sweaty.ui.utils.ImageUtils;

public class Images {

	public static final String imgPath = "at/int32/sweaty/examples/images/";
	public static final Image toolbarSave = ImageUtils.getImageFromResources(imgPath + "save.png");
	public static final Image toolbarEdit = ImageUtils.getImageFromResources(imgPath + "edit.png");
	public static final Image toolbarDelete = ImageUtils.getImageFromResources(imgPath + "delete.png");
	public static final Image trayIcon = ImageUtils.getImageFromResources(imgPath + "tray.png");
}
