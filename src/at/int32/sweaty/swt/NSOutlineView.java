package at.int32.sweaty.swt;

import org.eclipse.swt.internal.cocoa.NSTableView;
import org.eclipse.swt.internal.cocoa.OS;
import org.eclipse.swt.internal.cocoa.id;

public class NSOutlineView extends NSTableView {
	public NSOutlineView() {
		super();
	}

	public NSOutlineView(long /* int */ id) {
		super(id);
	}

	public NSOutlineView(id id) {
		super(id);
	}

	public void expandItem(id item) {
		OS.objc_msgSend(this.id, org.eclipse.swt.internal.cocoa.OS.sel_registerName("expandItem:"), item.id);
	}
}
