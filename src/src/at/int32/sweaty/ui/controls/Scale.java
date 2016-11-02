package at.int32.sweaty.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import at.int32.sweaty.ui.Control;

public class Scale extends Widget<org.eclipse.swt.widgets.Scale> {
	
	private IOnValueChangedListener listener;
	private int currValue;
	
	public interface IOnValueChangedListener {
		public void onChanged(int value);
	}

	public Scale(Control parent) {
		super(parent);
	}
	
	public Scale min(int min) {
		ctrl.setMinimum(min);
		return this;
	}
	
	public Scale max(int max) {
		ctrl.setMaximum(max);
		return this;
	}
	
	public Scale value(int value) {
		ctrl.setSelection(value);
		return this;
	}
	
	public Scale changed(IOnValueChangedListener listener) {
		this.listener = listener;
		this.ctrl.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		        int tmp = ctrl.getSelection();
		        
		        if(tmp != currValue) {
		        	currValue = tmp;
		        	if(Scale.this.listener != null)
		        		Scale.this.listener.onChanged(currValue);
		        }
		      }
		    });
		return this;
	}

	@Override
	public org.eclipse.swt.widgets.Scale getBaseControl(Composite parent) {
		return new org.eclipse.swt.widgets.Scale(parent, SWT.HORIZONTAL);
	}

}
