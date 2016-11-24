package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import at.int32.sweaty.ui.Control;

public class Spinner extends Widget<org.eclipse.swt.widgets.Label> {

	private Image img;
	private Thread thread;
	private int degrees = 0;
	private Canvas canvas;

	public Spinner(Control parent) {
		super(parent);

		thread = new Thread(new Runnable() {

			@Override
			public void run() {

				Thread.currentThread();
				while (!Thread.interrupted()) {

					try {
						Thread.sleep(50);
						degrees += 10;

						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								try {
								canvas.redraw();
								} catch(Exception e) {
									Spinner.this.stop();
								}
							}
						});

					} catch (Exception e) {
					}
					if (degrees >= 360)
						degrees = 0;
				}
			}
		});
	}

	public Spinner image(Image img) {
		this.img = img;
		return this;
	}

	public Spinner size(int size) {
		data().widthHint = size;
		data().heightHint = size;
		return this;
	}

	public Spinner start() {
		canvas = new Canvas(ctrl(), SWT.NONE);
		canvas.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.setAdvanced(true);

				Rectangle b = img.getBounds();
				int offset = 0;

				Transform transform = new Transform(Display.getDefault());
				// The rotation point is the center of the image
				transform.translate(offset + b.width / 2, offset + b.height / 2);
				// Rotate
				transform.rotate(degrees);
				// Back to the orginal coordinate system
				transform.translate(offset - b.width / 2, offset - b.height / 2);
				gc.setTransform(transform);
				gc.drawImage(img, 0, 0);
				gc.dispose();
				transform.dispose();
			}
		});

		ctrl.redraw();
		thread.start();
		return this;
	}

	public Spinner stop() {
		thread.interrupt();
		return this;
	}

	@Override
	public Spinner center() {
		return (Spinner) super.center();
	}

	@Override
	public Spinner visible(boolean visible) {
		return (Spinner) super.visible(visible);
	}

	@Override
	public org.eclipse.swt.widgets.Label getBaseControl(Composite parent, int style) {
		return new org.eclipse.swt.widgets.Label(parent, SWT.NONE);
	}

}
