package at.int32.sweaty.ui.annotations;

import at.int32.sweaty.ui.Control;

public class OnValueChangedEvent<T> extends OnEvent {

	private T value;

	public OnValueChangedEvent(Control source, T value) {
		super(source);
		this.value = value;
	}

	public T value() {
		return this.value;
	}

}
