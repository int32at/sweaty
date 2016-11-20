package at.int32.sweaty.ui.annotations;

import at.int32.sweaty.ui.Control;

public class OnTextChangedEvent extends OnEvent {

	private String text;

	public OnTextChangedEvent(Control source, String text) {
		super(source);
		this.text = text;
	}

	public String text() {
		return this.text;
	}
}
