package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Layout;

public class List extends Control {

	private ScrolledComposite scrolledResults;
	private Composite listResults;

	public List(Control parent) {
		create(parent.ctrl());
	}

	@Override
	public void onInit() {
	}

	@Override
	public Composite onCreate() {
		scrolledResults = new ScrolledComposite(parent(), SWT.BORDER | SWT.V_SCROLL);
		scrolledResults.setLayout(Layout.Grid.layout(1));
		scrolledResults.setLayoutData(Layout.Grid.data(0, true, true));
		scrolledResults.setExpandHorizontal(true);
		scrolledResults.setExpandVertical(true);
		scrolledResults.setMinSize(200, 655);
		scrolledResults.addListener(SWT.Activate, new Listener() {
			public void handleEvent(Event e) {
				scrolledResults.setFocus();
			}
		});

		listResults = new Composite(scrolledResults, SWT.NONE);
		listResults.setLayout(Layout.Grid.layout(1));
		listResults.setLayoutData(Layout.Grid.data(0, true, true));

		scrolledResults.setContent(listResults);

		return listResults;
	}

}
