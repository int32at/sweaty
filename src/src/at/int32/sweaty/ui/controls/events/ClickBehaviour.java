package at.int32.sweaty.ui.controls.events;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class ClickBehaviour extends MouseAdapter {

	public static final int LEFT_BUTTON = 1;
	private boolean armed;
	private final IOnClickListener action;
	private boolean doubleClick = false;
	private ClickType type = ClickType.SINGLE;

	public ClickBehaviour(IOnClickListener action) {
		this.action = action;
	}

	@Override
	public void mouseDown(MouseEvent event) {
		doubleClick = false;
		if (event.button == LEFT_BUTTON) {
			this.armed = true;
		}
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		doubleClick = true;
		ClickBehaviour.this.action.onClick(ClickType.DOUBLE);
	}

	@Override
	public void mouseUp(MouseEvent e) {
		if (armed && inRange(e)) {

			Display.getDefault().timerExec(Display.getDefault().getDoubleClickTime() / 2,
					new Runnable() {
						public void run() {
							if (!doubleClick)
								ClickBehaviour.this.action.onClick(ClickType.SINGLE);
						}
					});

		}
		armed = false;
	}

	static boolean inRange(MouseEvent event) {
		Point size = ((Control) event.widget).getSize();
		return event.x >= 0 && event.x <= size.x && event.y >= 0 && event.y <= size.y;
	}

	public interface IOnClickListener {
		public void onClick(ClickType type);
	}

	public enum ClickType {
		SINGLE, DOUBLE, PRESS
	}
}
