package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;

public class UserStatus extends Widget<Composite> {

	private Color color;
	
	public UserStatus(Control parent) {
		super(parent);
	}
	
	public UserStatus color(Color color) {
		this.color = color;
		ctrl().redraw();
		return this;
	}
	
	public UserStatus size(final int size, final int pos) {
		data().widthHint = size * 3;
		data().heightHint = size * 3;
		ctrl().addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.setAntialias(SWT.ON);
				gc.setForeground(color);
				gc.setLineWidth(size);
				gc.drawOval(size, pos, size, size);
			}
		});
		ctrl().redraw();
		
		return this;
	}

	@Override
	public Composite getBaseControl(Composite parent) {
		return createDefaultComposite();
	}

}
