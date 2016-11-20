package at.int32.sweaty.ui.annotations;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.controls.events.ClickBehaviour.ClickType;

public class OnClickEvent extends OnEvent{

	private ClickType type;

	public OnClickEvent(Control source, ClickType type) {
		super(source);
		this.type = type;
	}

	public ClickType type() {
		return type;
	}
}
