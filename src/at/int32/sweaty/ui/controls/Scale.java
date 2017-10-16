package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Layout;
import at.int32.sweaty.ui.annotations.OnValueChanged;
import at.int32.sweaty.ui.annotations.OnValueChangedEvent;

public class Scale extends Widget<org.eclipse.swt.widgets.Scale> {

	private int currValue;

	public Scale(Control parent) {
		this(parent, SWT.HORIZONTAL);
	}

	public Scale(Control parent, int style) {
		super(parent, style);
		this.ctrl.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int tmp = ctrl.getSelection();

				if (tmp != currValue) {
					currValue = tmp;
					events.post(OnValueChanged.class,
							new OnValueChangedEvent<Integer>(Scale.this,
									currValue));
				}
			}
		});
	}

	public Scale min(int min) {
		ctrl.setMinimum(min);
		return this;
	}

	public Scale max(int max) {
		ctrl.setMaximum(max);
		return this;
	}

	public Scale value(int value) {
		ctrl.setSelection(value);
		return this;
	}

	public Scale increment(int value) {
		ctrl.setPageIncrement(value);
		return this;
	}

	public Scale changed(Object o) {
		events.register(OnValueChanged.class, o);
		return this;
	}

	@Override
	public org.eclipse.swt.widgets.Scale getBaseControl(Composite parent,
			int style) {
		org.eclipse.swt.widgets.Scale scale = new org.eclipse.swt.widgets.Scale(parent, style);
		GridData data = Layout.Grid.data(0, true, false);
		scale.setLayoutData(data);		
		return scale;
	}

}
