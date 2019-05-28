package at.int32.sweaty.ui.controls;

import org.eclipse.swt.internal.cocoa.NSButton;
import org.eclipse.swt.internal.cocoa.NSView;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class SourceList extends Control {

	public SourceList(Composite parent, int style) {
		super(parent, checkStyle(style));
		createWidget();
		// view.drawRect(rect);
	}

	@Override
	protected void checkSubclass() {
		return;
	}

	protected void createWidget() {
		// if ((style & SWT.PUSH) == 0)
		// state |= THEME_BACKGROUND;
		// NSButton widget = (NSButton) new SWTButton().alloc();
		// widget.init();
		// NSButtonCell cell = (NSButtonCell) new
		// SWTButtonCell().alloc().init();
		// widget.setCell(cell);
		// cell.release();
		// if ((style & (SWT.PUSH | SWT.TOGGLE)) != 0 && (style & SWT.FLAT) ==
		// 0) {
		// NSView superview = parent.view;
		// while (superview != null) {
		// if (superview.isKindOfClass(OS.class_NSTableView)) {
		// style |= SWT.FLAT;
		// break;
		// }
		// superview = superview.superview();
		// }
		// }
		// int type = OS.NSMomentaryLightButton;
		// if ((style & SWT.PUSH) != 0) {
		// if ((style & SWT.FLAT) != 0) {
		// widget.setBezelStyle(OS.NSShadowlessSquareBezelStyle);
		// } else {
		// widget.setBezelStyle((style & SWT.WRAP) != 0 ?
		// OS.NSRegularSquareBezelStyle : OS.NSRoundedBezelStyle);
		// }
		// } else if ((style & SWT.CHECK) != 0) {
		// type = OS.NSSwitchButton;
		// } else if ((style & SWT.RADIO) != 0) {
		// type = OS.NSRadioButton;
		// radioParent = (SWTView) new SWTView().alloc().init();
		// } else if ((style & SWT.TOGGLE) != 0) {
		// type = OS.NSPushOnPushOffButton;
		// if ((style & SWT.FLAT) != 0) {
		// widget.setBezelStyle(OS.NSShadowlessSquareBezelStyle);
		// } else {
		// widget.setBezelStyle((style & SWT.WRAP) != 0 ?
		// OS.NSRegularSquareBezelStyle : OS.NSRoundedBezelStyle);
		// }
		// } else if ((style & SWT.ARROW) != 0) {
		// widget.setBezelStyle(OS.NSShadowlessSquareBezelStyle);
		// }
		// widget.setButtonType(type);
		// widget.setTitle(NSString.string());
		// widget.setImagePosition(OS.NSImageLeft);
		// widget.setTarget(widget);
		// widget.setAction(OS.sel_sendSelection);
		view = (NSView) new NSButton().alloc().init();
		// _setAlignment(style);
	}

	static int checkStyle(int style) {
		return 0;
	}

}
