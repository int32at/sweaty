package at.int32.sweaty.ui;

import org.eclipse.swt.events.TypedEvent;

@FunctionalInterface
public interface EventHandler<E extends TypedEvent, C extends Control> {

	void onEvent(E event, C source);
}
