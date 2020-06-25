package practice.suddenGame;

import javax.swing.JPanel;

public class ChangePanel {
	public static void changePanel(MainFrame mf, JPanel op, JPanel np) {
		mf.remove(op);
		mf.add(np);
		np.setLayout(null);
		np.setSize(1600,900);
		mf.repaint();
		}
}
