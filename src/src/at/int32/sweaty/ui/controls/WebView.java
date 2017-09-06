package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Layout;

public class WebView extends Widget<Browser> {

	public WebView(Control parent) {
		super(parent);
	}

	public WebView url(String url) {
		this.ctrl.setUrl(url);
		return this;
	}

	@Override
	public Browser getBaseControl(Composite parent, int style) {
		Browser b =  new Browser(parent, SWT.NONE);
		b.setLayout(Layout.Grid.layout(1));
		b.setLayoutData(Layout.Grid.data(0, true, true));
		return b;
	}

}
