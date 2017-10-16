package at.int32.sweaty.ui.controls;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Layout;
import at.int32.sweaty.ui.annotations.OnValueChanged;
import at.int32.sweaty.ui.annotations.OnValueChangedEvent;

public class Dropdown extends Widget<Combo> {

	private ArrayList<DropdownItem> items;

	public Dropdown(Control parent) {
		super(parent);

		this.items = new ArrayList<DropdownItem>();

		this.ctrl.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				events.post(OnValueChanged.class,
						new OnValueChangedEvent<DropdownItem>(Dropdown.this,
								selection()));

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	public DropdownItem selection() {
		return items.get(this.ctrl.getSelectionIndex());
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

	public Dropdown add(String key, String value) {
		this.ctrl.add(value);
		this.items.add(new DropdownItem(key, value));
		return this;
	}

	public Dropdown add(DropdownItem item) {
		return this.add(item.key(), item.value());
	}

	public Dropdown add(DropdownItem... items) {
		for (DropdownItem item : items) {
			add(item);
		}

		return this;
	}

	public Dropdown selectByItem(DropdownItem item) {
		if (item == null)
			selectByIndex(0);
		else
			selectByKey(item.key());
		return this;
	}

	public Dropdown selectByValue(String value) {
		String[] items = this.ctrl.getItems();

		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(value)) {
				selectByIndex(i);
				break;
			}
		}
		return this;
	}

	public Dropdown selectByKey(String key) {
		for (int i = 0; i < items.size(); i++) {
			DropdownItem item = items.get(i);

			if (item.key().equals(key)) {
				selectByIndex(i);
				break;
			}
		}

		return this;
	}

	public Dropdown selectByIndex(int index) {
		this.ctrl.select(index);
		return this;
	}

}
