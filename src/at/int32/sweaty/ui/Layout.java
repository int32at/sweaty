package at.int32.sweaty.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

public class Layout {

	public static class Grid {

		public static org.eclipse.swt.layout.GridLayout layout(int columns) {
			GridLayout layout = new GridLayout();
			layout.marginBottom = 0;
			layout.marginTop = 0;
			layout.marginLeft = 0;
			layout.marginRight = 0;
			layout.horizontalSpacing = 0;
			layout.verticalSpacing = 0;
			layout.marginWidth = 0;
			layout.marginHeight = 0;
			layout.makeColumnsEqualWidth = true;
			layout.numColumns = columns;
			return layout;
		}

		public static org.eclipse.swt.layout.GridData data(int span, boolean grabHor,
				boolean grabVert) {
			GridData data = new GridData(SWT.DEFAULT, SWT.DEFAULT);
			data.horizontalAlignment = SWT.FILL;
			data.verticalAlignment = SWT.FILL;
			data.grabExcessHorizontalSpace = grabHor;
			data.grabExcessVerticalSpace = grabVert;
			data.horizontalSpan = span;
			return data;
		}
	}
}
