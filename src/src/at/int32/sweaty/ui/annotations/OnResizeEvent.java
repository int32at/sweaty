package at.int32.sweaty.ui.annotations;

import org.eclipse.swt.graphics.Rectangle;

import at.int32.sweaty.ui.Control;

public class OnResizeEvent extends OnEvent {

	private Rectangle rect;

	public OnResizeEvent(Control source, Rectangle rect) {
		super(source);
		this.rect = rect;
	}

	public Rectangle rectangle() {
		return this.rect;
	}
}
