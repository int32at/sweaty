package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Layout;
import at.int32.sweaty.ui.annotations.OnValueChanged;
import at.int32.sweaty.ui.annotations.OnValueChangedEvent;

public class Dropdown extends Widget<Combo> {

	public Dropdown(Control parent) {
		super(parent);

		this.ctrl.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				events.post(OnValueChanged.class,
						new OnValueChangedEvent<String>(Dropdown.this,
								selection()));

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	public String selection() {
		return this.ctrl.getItem(this.ctrl.getSelectionIndex());
	}

	public Dropdown changed(Object o) {
		events.register(OnValueChanged.class, o);
		return this;
	}

	@Override
	public Combo getBaseControl(Composite parent, int style) {
		Combo c = new Combo(parent, SWT.NONE | SWT.READ_ONLY);
		c.setLayout(Layout.Grid.layout(0));
		c.setLayoutData(Layout.Grid.data(0, true, false));
		return c;
	}

	public Dropdown width(int width) {

		return this;
	}

	public Dropdown add(String item) {
		this.ctrl.add(item);
		return this;
	}

	public Dropdown add(String... items) {
		for (String item : items) {
			add(item);
		}

		return this;
	}

	public Dropdown select(String text) {
		String[] items = this.ctrl.getItems();

		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(text)) {
				select(i);
				break;
			}
		}
		return this;
	}

	public Dropdown select(int index) {
		this.ctrl.select(index);
		return this;
	}

}
