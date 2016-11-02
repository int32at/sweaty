package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.controls.events.ClickBehaviour.ClickType;
import at.int32.sweaty.ui.controls.events.ClickBehaviour.IOnClickListener;

public class ToggleButton extends Widget<org.eclipse.swt.widgets.Label> {

	private boolean checked = false;
	private Image on, off;
	private IOnValueChangedListener listener;
	
	public interface IOnValueChangedListener {
		public void onToggleChanged(boolean checked);
	}
	
	public ToggleButton(Control parent) {
		super(parent);
	}
	
	public ToggleButton image(Image img) {
		ctrl.setImage(img);
		return this;
	}
	
	public ToggleButton on(Image img) {
		on = img;
		return this;
	}
	
	public ToggleButton off(Image img) {
		off = img;
		return this;
	}

	public ToggleButton on() {
		checked = true;
		image(on);
		return this;
	}
	
	public ToggleButton off() {
		checked = false;
		image(off);
		return this;
	}
	
	public ToggleButton toggle(IOnValueChangedListener listener) {
		this.listener = listener;
		registerListener();
		return this;
	}

	@Override
	public org.eclipse.swt.widgets.Label getBaseControl(Composite parent) {
		return new org.eclipse.swt.widgets.Label(parent, SWT.NONE);
	}
	
	private void registerListener() {
		this.click(new IOnClickListener() {
			
			@Override
			public void onClick(ClickType type) {
				checked = !checked;
				
				if(listener != null)
					listener.onToggleChanged(checked);
				
				image(checked ? on : off);
			}
		});
	}

}
