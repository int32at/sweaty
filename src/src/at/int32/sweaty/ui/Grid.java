package at.int32.sweaty.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import at.int32.sweaty.ui.annotations.OnResize;
import at.int32.sweaty.ui.annotations.OnResizeEvent;

public class Grid extends Control {

	private Image gradientImage;
	private Color gradientFrom, gradientTo;

	public Grid(Control parent) {
		this(parent, true, true);
	}

	public Grid(Control parent, boolean fillVert) {
		this(parent, fillVert, true);
	}

	public Grid(Control parent, boolean fillVert, boolean fillHor) {
		create(parent.ctrl());
		data().grabExcessVerticalSpace = fillVert;
		data().grabExcessHorizontalSpace = fillHor;

		this.ctrl().addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event e) {
				events.post(OnResize.class, new OnResizeEvent(Grid.this, ctrl()
						.getClientArea()));
				
				if(gradientFrom != null && gradientTo != null)
					changeGradientBg();
			}
		});
	}

	public Grid resize(Object o) {
		events.register(OnResize.class, o);
		return this;
	}

	public Grid width(int width) {
		data().widthHint = width;
		return this;
	}

	public Grid height(int height) {
		data().heightHint = height;
		return this;
	}

	public Grid minWidth(int width) {
		data().minimumWidth = width;
		return this;
	}

	public Grid minHeight(int height) {
		data().minimumHeight = height;
		return this;
	}

	public Grid margin(int all) {
		return margin(all, all, all, all);
	}

	public Grid margin(int top, int right, int bottom, int left) {
		if (top > -1)
			layout().marginTop = top;
		if (right > -1)
			layout().marginRight = right;
		if (bottom > -1)
			layout().marginBottom = bottom;
		if (left > -1)
			layout().marginLeft = left;

		return this;
	}

	public Grid marginTop(int margin) {
		return margin(margin, -1, -1, -1);
	}

	public Grid marginRight(int margin) {
		return margin(1, margin, -1, -1);
	}

	public Grid marginBottom(int margin) {
		return margin(-1, -1, margin, -1);
	}

	public Grid marginLeft(int margin) {
		return margin(-1, -1, -1, margin);
	}

	public Grid marginHorizontal(int margin) {
		return margin(-1, margin, -1, margin);
	}

	public Grid marginVertical(int margin) {
		return margin(margin, -1, margin, -1);
	}

	public Grid spacing(int all) {
		return spacing(all, all);
	}

	public Grid spacing(int hor, int vert) {
		layout().horizontalSpacing = hor;
		layout().verticalSpacing = vert;
		return this;
	}

	public Grid columns(int columns) {
		return columns(columns, true);
	}

	public Grid columns(int columns, boolean makeColumnsEqualWidth) {
		layout().numColumns = columns;
		layout().makeColumnsEqualWidth = makeColumnsEqualWidth;
		return this;
	}

	public Grid span(int columns) {
		data().horizontalSpan = columns;
		return this;
	}

	@Override
	public Grid background(Color color) {
		return (Grid) super.background(color);
	}

	public Grid background(Color from, Color to) {
		gradientFrom = from;
		gradientTo = to;
		ctrl().redraw();
		return this;
	}

	@Override
	public Grid background(int r, int g, int b) {
		return (Grid) super.background(r, g, b);
	}

	@Override
	public void onInit() {
	}

	@Override
	public Composite onCreate() {
		return createDefaultComposite();
	}
	
	private void changeGradientBg() {
		Rectangle rect = ctrl().getClientArea();
		Image newImage = new Image(ctrl().getDisplay(), 1, Math.max(1,
				rect.height));
		GC gc = new GC(newImage);
		gc.setForeground(gradientFrom);
		gc.setBackground(gradientTo);
		gc.fillGradientRectangle(0, 0, 1, rect.height, true);
		gc.dispose();
		ctrl().setBackgroundImage(newImage);

		if (gradientImage != null)
			gradientImage.dispose();

		gradientImage = newImage;
	
    }
}
