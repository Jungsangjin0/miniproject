package miniproject.views;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ChangePanel {
	private JFrame mf;
	private JPanel panel;
	private JPanel panel2;
	
	public ChangePanel(JFrame mf, JPanel panel, JPanel panel2) {
		this.mf = mf;
		this.panel = panel;
		this.panel2 = panel2;
	}

	public static void changePanel(MainFrame mf, JPanel op, JPanel np){
		mf.remove(op);
		mf.add(np);
		mf.repaint();
		mf.revalidate();
	}
}


		

