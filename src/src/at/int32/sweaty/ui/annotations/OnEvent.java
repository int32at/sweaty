package at.int32.sweaty.ui.annotations;

import at.int32.sweaty.ui.Control;

public abstract class OnEvent {

	private Control source;

	public OnEvent(Control source) {
		this.source = source;
	}
	
	public Control source() {
		return this.source;
	}
}
