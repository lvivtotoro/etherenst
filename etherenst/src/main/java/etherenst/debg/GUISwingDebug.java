package etherenst.debg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import etherenst.JORts;
import etherenst.Realm;
import etherenst.Unit;
import etherenst.math.AABB;

public class GUISwingDebug extends Debug {

	private JFrame frame = new JFrame("OpenStrat Server GUI Debugger");
	private JPanel jpanel = new Panel();

	private int session = 0;

	public GUISwingDebug(JORts os) {
		super(os);
		frame.setSize(640, 360);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(jpanel);
		frame.pack();

		frame.setVisible(true);
	}

	@Override
	public void update() {
		if (jpanel != null) // due to multithreading bullshit, it will be null at first
			jpanel.repaint();
	}

	public class Panel extends JPanel {

		private static final long serialVersionUID = 1l;

		int camX = 320, camY = 180;

		{
			setPreferredSize(new Dimension(640, 360));
		}

		public void paintComponent(Graphics xaxa$__$хаха) {
			super.paintComponent(xaxa$__$хаха);
			Graphics2D g = (Graphics2D) xaxa$__$хаха;
			g.translate(camX, camY);
			Realm sesh = os.realms()[session];
			for (Unit unit : sesh.units()) {
				AABB aabb = unit.aabb();
				g.setColor(Color.BLACK);
				g.drawRect((int) aabb.x(), (int) aabb.y(), (int) aabb.w(), (int) aabb.h());
			}
		}

	}

}
