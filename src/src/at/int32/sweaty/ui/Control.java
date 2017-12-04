package at.int32.sweaty.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import at.int32.sweaty.ui.annotations.Events;
import at.int32.sweaty.ui.annotations.OnClick;
import at.int32.sweaty.ui.annotations.OnClickEvent;
import at.int32.sweaty.ui.controls.events.ClickBehaviour;
import at.int32.sweaty.ui.controls.events.ClickBehaviour.ClickType;
import at.int32.sweaty.ui.controls.events.ClickBehaviour.IOnClickListener;
import at.int32.sweaty.ui.dnd.IDragSourceListener;
import at.int32.sweaty.ui.dnd.IDragTargetListener;

public abstract class Control {

	private Composite parent;
	private Composite ctrl;
	private IOnClickListener clickListener;

	private IDragSourceListener dragSourceListener;
	private IDragTargetListener dragTargetListener;
	protected Events events;

	public abstract void onInit();

	public abstract Composite onCreate();

	public void create(Composite parent) {
		this.events = new Events();
		this.parent = parent;
		this.ctrl = onCreate();
		this.ctrl.setBackgroundMode(SWT.INHERIT_FORCE);

		onInit();
	}

	public Composite parent() {
		return parent;
	}

	public Composite ctrl() {
		return ctrl;
	}

	public Control update() {
		ctrl.layout();
		parent().layout();
		return this;
	}

	public Control background(Color color) {
		ctrl().setBackground(color);
		return this;
	}

	public Control background(int r, int g, int b) {
		return background(Colors.get(r, g, b));
	}

	public Control visible(boolean visible) {
		ctrl().setVisible(visible);
		return this;
	}

	public Control dispose() {
		ctrl().dispose();
		return this;
	}

	public Control handCursor() {
		ctrl().setCursor(new Cursor(Display.getDefault(), SWT.CURSOR_HAND));
		return this;
	}

	public Control normalCursor() {
		ctrl().setCursor(new Cursor(Display.getDefault(), SWT.CURSOR_ARROW));
		return this;
	}

	protected Composite createDefaultComposite() {
		return createDefaultComposite(parent(), SWT.PUSH);
	}

	protected Composite createDefaultComposite(Composite shell, int style) {
		Composite composite = new Composite(shell, style);
		composite.setLayout(Layout.Grid.layout(1));
		composite.setLayoutData(Layout.Grid.data(0, true, true));
		return composite;
	}

	protected GridData data() {
		return (GridData) ctrl().getLayoutData();
	}

	protected GridLayout layout() {
		return (GridLayout) ctrl().getLayout();
	}

	public Control click(final Object o) {
		events.register(OnClick.class, o);

		if (clickListener == null) {
			clickListener = new IOnClickListener() {

				@Override
				public void onClick(ClickType type) {
					events.post(OnClick.class, new OnClickEvent(Control.this,
							type));
				}
			};

			addMouseListener(this.ctrl, new ClickBehaviour(clickListener),
					false);
		}

		return this;
	}

	public <T> Control dragSource(IDragSourceListener listener) {
		this.dragSourceListener = listener;
		registerDrag();
		return this;
	}

	public <T> Control dragTarget(IDragTargetListener listener) {
		this.dragTargetListener = listener;
		registerDrop();
		return this;
	}

	private void addMouseListener(org.eclipse.swt.widgets.Control c,
			MouseListener ma, boolean propagateToChildren) {
		c.addMouseListener(ma);
		if (c instanceof Composite) {
			for (final org.eclipse.swt.widgets.Control cc : ((Composite) c)
					.getChildren()) {
				addMouseListener(cc, ma, propagateToChildren);
			}
		}
	}

	private void registerDrag() {
		DragSource source = new DragSource(this.ctrl, DND.DROP_NONE);

		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
		source.setTransfer(types);

		source.addDragListener(new DragSourceListener() {

			@Override
			public void dragStart(DragSourceEvent e) {
			}

			@Override
			public void dragSetData(DragSourceEvent event) {
				if (dragSourceListener != null) {
					event.data = dragSourceListener.onDragged();
				}
			}

			@Override
			public void dragFinished(DragSourceEvent e) {
			}
		});
	}

	private void registerDrop() {
		DropTarget target = new DropTarget(this.ctrl, DND.DROP_DEFAULT
				| DND.DROP_COPY | DND.DROP_MOVE);

		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
		target.setTransfer(types);

		target.addDropListener(new DropTargetAdapter() {
			public void drop(DropTargetEvent event) {
				if (dragTargetListener != null)
					dragTargetListener.onDragged(event.data.toString());
			}
		});
	}
}
