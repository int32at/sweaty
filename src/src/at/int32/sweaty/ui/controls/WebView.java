package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Layout;
import at.int32.sweaty.ui.annotations.OnLoaded;
import at.int32.sweaty.ui.annotations.OnLoadedEvent;

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
		return this.url(url, null);
	}
	
	public WebView url(String url, Object loaded) {
		if (this.spinner == null && imgSpinner != null) {
			this.spinner = new Spinner(this).size(sizeSpinner).center();
			this.spinner.image(imgSpinner);
			this.spinner.start();
		}
		
		if(loaded != null) {
			events.register(OnLoaded.class, loaded);
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
				events.post(OnLoaded.class, new OnLoadedEvent(WebView.this));
			}

			@Override
			public void changed(ProgressEvent arg0) {
			}
		});
		return this;
	}
	
	public String url() {
		return this.ctrl.getUrl();
	}
	
	public Browser browser() {
		return this.ctrl;
	}

	@Override
	public Browser getBaseControl(Composite parent, int style) {
		Browser b = new Browser(parent, SWT.NONE);
		b.setLayoutData(new GridData(GridData.FILL_BOTH));
		b.setSize(parent.getSize());
		b.setVisible(true);
		b.setLayoutData(Layout.Grid.data(0, true, true));
		return b;
	}

}
