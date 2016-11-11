package at.int32.sweaty.ui.controls;

import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.controls.events.ClickBehaviour.IOnClickListener;
import at.int32.sweaty.ui.utils.ImageUtils;
import at.int32.sweaty.ui.utils.SWTGraphics2D;
import at.int32.sweaty.ui.utils.SWTUtils;

public class Avatar extends Widget<Composite>{

	private Color color;
	
	public Avatar(Control parent) {
		super(parent);
	}
	
	public Avatar size(int size) {
		data().widthHint = size;
		data().heightHint = size;
		return this;
	}
	
	@Override
	public Avatar center() {
		return (Avatar)super.center();
	}
	
	public Avatar color(Color color) {
		this.color = color;
		return this;
	}
	
	public Avatar image(final Image img) {
		ctrl().addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				SWTGraphics2D gb = null;
				int size = data().widthHint;

				try {
					if (img == null)
						return;

					BufferedImage bi = SWTUtils.convertToAWT(img.getImageData());
					gb = new SWTGraphics2D(e.gc);
					RoundRectangle2D r = new RoundRectangle2D.Float(0, 0, size, size, size, size);
					gb.setClip(r);
					gb.drawImage(bi, 0, 0, null);

					if(color != null) {
						e.gc.setForeground(color);
						e.gc.setLineWidth(2);
						e.gc.drawOval(0, 0, size, size);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					if (gb != null)
						gb.dispose();
				}
			}
		});

		ctrl().redraw();

		
		return this;
	}
	
	public Avatar image(final String base64) {
		
		try {
			return image(ImageUtils.getImageFromBase64(base64, data().widthHint, data().heightHint));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
	@Override
	public Avatar handCursor() {
		return (Avatar)super.handCursor();
	}

	@Override
	public Composite getBaseControl(Composite parent) {
		return createDefaultComposite();
	}

}
