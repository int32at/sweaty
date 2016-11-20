package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
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
		scrolledResults = new ScrolledComposite(parent(), SWT.V_SCROLL);
		scrolledResults.setLayout(Layout.Grid.layout(1));
		scrolledResults.setLayoutData(Layout.Grid.data(0, true, true));
		scrolledResults.setExpandHorizontal(true);
		scrolledResults.setExpandVertical(true);
		scrolledResults.addListener(SWT.Activate, new Listener() {
			public void handleEvent(Event e) {
				scrolledResults.setFocus();
			}
		});

		listResults = new Composite(scrolledResults, SWT.NONE);
		listResults.setLayout(Layout.Grid.layout(1));

		GridData data = Layout.Grid.data(0, true, false);
		listResults.setLayoutData(data);

		scrolledResults.setContent(listResults);

		return listResults;
	}

	@Override
	public Control update() {
		int height = 0;

		for (org.eclipse.swt.widgets.Control c : listResults.getChildren()) {
			height += c.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
		}

		listResults.setSize(listResults.getSize().x, height);
		listResults.layout();
		scrolledResults.setMinSize(0, height);
		scrolledResults.layout();
		return super.update();
	}

}
