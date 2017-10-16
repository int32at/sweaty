package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Layout;

public class WebView extends Widget<Browser> {

	private Spinner spinner;
	private Image imgSpinner;
	private int sizeSpinner;

	public WebView(Control parent) {
		super(parent);
		this.ctrl.setVisible(false);
		this.ctrl.setTouchEnabled(true);
		this.ctrl.setJavascriptEnabled(true);
	}

	public WebView loading(Image img, int size) {
		this.imgSpinner = img;
		this.sizeSpinner = size;
		return this;
	}
	
	public WebView url(String url) {
		if (this.spinner == null && imgSpinner != null) {
			this.spinner = new Spinner(this).size(sizeSpinner).center();
			this.spinner.image(imgSpinner);
			this.spinner.start();
		}

		this.ctrl.setVisible(false);
		this.ctrl.setUrl(url);
		this.ctrl.addProgressListener(new ProgressListener() {

			@Override
			public void completed(ProgressEvent arg0) {
				if (spinner != null)
					spinner.dispose();

				WebView.this.update();
				ctrl.setVisible(true);
			}

			@Override
			public void changed(ProgressEvent arg0) {
			}
		});
		return this;
	}

	@Override
	public Browser getBaseControl(Composite parent, int style) {
		Browser b = new Browser(parent, SWT.NONE);
		b.setLayout(Layout.Grid.layout(1));
		b.setLayoutData(Layout.Grid.data(0, true, true));
		return b;
	}

}
