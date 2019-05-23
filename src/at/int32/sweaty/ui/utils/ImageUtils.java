package at.int32.sweaty.ui.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ImageUtils {

	public static Image getImageFromResources(String path) {
		return new Image(null, ImageUtils.class.getResourceAsStream(path));
	}

	public static Image getImageFromBase64(String base64) throws UnsupportedEncodingException {
		return new Image(Display.getCurrent(), new ByteArrayInputStream(Base64.decode(base64)));
	}

	public static Image getImageFromBase64(String base64, int width, int height) throws UnsupportedEncodingException {

		Display display = Display.getCurrent();
		Image img = new Image(display, new ByteArrayInputStream(Base64.decode(base64)));
		return resize(img, width, height);
	}

	public static Image getImageFromPath(String path, int width, int height) throws UnsupportedEncodingException {
		return new Image(null, ResourceLoader.image(path));
	}

	public static Image getImageFromPathExternal(String path, int width, int height)
			throws UnsupportedEncodingException {

		return new Image(Display.getCurrent(), path);
	}

	public static Image getImage(byte[] data, int width, int height) throws UnsupportedEncodingException {

		Display display = Display.getCurrent();
		Image img = new Image(display, new ByteArrayInputStream(data));
		return resize(img, width, height);
	}

	public static Image getRoundedImage(String base64, int width, int height) throws UnsupportedEncodingException {
		return getImageFromBase64(base64, width, height);
	}

	private static Image resize(Image image, int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose(); // don't forget about me!
		return scaled;
	}

	public static String getBase64FromPath(String path, int width, int height) {
		File file = new File(path);

		byte[] data;
		try {
			BufferedImage img = ImageIO.read(file);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			ImageIO.write(img, "png", stream);
			return Base64.encode(stream.toByteArray());

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return "";
	}
}
