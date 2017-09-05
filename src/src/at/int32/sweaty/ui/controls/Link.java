package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;

public class Link extends Widget<org.eclipse.swt.widgets.Link> {

	private String link, text;

	public Link(Control parent) {
		super(parent);
	}

	public String text() {
		return this.text;
	}

	public String link() {
		return this.link;
	}

	public Link link(String text, String link) {
		this.text = text;
		this.link = link;

		String full = "<a href=\"" + link + "\">" + text + "</a>";

		this.ctrl.setText(full);

		return this;
	}

	@Override
	public org.eclipse.swt.widgets.Link getBaseControl(Composite parent,
			int style) {
		org.eclipse.swt.widgets.Link link = new org.eclipse.swt.widgets.Link(
				parent, SWT.NONE);

		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Program.launch(Link.this.link);
			}

		});
		return link;
	}
}
