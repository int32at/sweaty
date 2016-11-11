package at.int32.sweaty.ui.annotations;

import at.int32.sweaty.ui.Control;

public class OnToggleEvent extends OnEvent {
	private Boolean checked;

	public OnToggleEvent(Control source, boolean checked) {
		super(source);
		this.checked = checked;
	}

	public boolean checked() {
		return this.checked;
	}
}
