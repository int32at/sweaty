package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Layout;

public class TextBox extends Widget<Text> {

	private IOnValueChangedListener listener;
	
	public interface IOnValueChangedListener {
		public void onTextChanged(String text);
	}
	
	public TextBox(Control parent) {
		super(parent);
	}

	public TextBox text(String text) {
		if(text == null) text = "";
		ctrl.setText(text);
		return this;
	}
	
	public String text() {
		return ctrl.getText();
	}

	@Override
	public TextBox center() {
		return (TextBox)super.center();
	}
	
	public TextBox background(Color color) {
		ctrl.setBackground(color);
		return this;
	}

	public TextBox foreground(Color color) {
		ctrl.setForeground(color);
		return this;
	}
	
	public TextBox width(int width) {
		data().widthHint = width;
		return this;
	}
	
	public TextBox height(int height) {
		data().heightHint = height;
		return this;
	}
	
	public TextBox changed(IOnValueChangedListener listener) {
		this.listener = listener;
		
		ctrl.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				if(TextBox.this.listener != null)
					TextBox.this.listener.onTextChanged(text());
			}
		});
		
		return this;
	}

	@Override
	public Text getBaseControl(Composite parent) {
		Text txt = new Text(parent, SWT.CENTER);
		txt.setLayoutData(Layout.Grid.data(0, true, true));
		txt.setEditable(true);
		return txt;
	}

}
