package at.int32.sweaty.ui.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class Events {
	private HashMap<Class<? extends Annotation>, ArrayList<Object>> listeners;

	public Events() {
		listeners = new HashMap<Class<? extends Annotation>, ArrayList<Object>>();
	}

	public void register(Class<? extends Annotation> event, Object listener) {
		if (!listeners.containsKey(event)) {
			listeners.put(event, new ArrayList<Object>());
		}

		listeners.get(event).add(listener);
	}

	public void post(Class<? extends Annotation> event, OnEvent args) {
		if (listeners.containsKey(event)) {
			ArrayList<Object> listenerObjects = listeners.get(event);

			for (Object object : listenerObjects) {
				run(event, object, args);
			}
		}
	}

	private void run(Class<? extends Annotation> clazz, Object target, Object... args) {
		Method[] methods = target.getClass().getMethods();

		for (Method method : methods) {
			Annotation annos = method.getAnnotation(clazz);
			if (annos != null) {
				try {
					method.invoke(target, args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
