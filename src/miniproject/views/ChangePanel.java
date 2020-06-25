package miniproject.views;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ChangePanel {
	private JFrame mf;
	private JPanel panel;
	private JPanel panel2;
	
	public ChangePanel() {
		
	}
	


	public static void changePanel(MainFrame mf, JPanel op, JPanel np){
		mf.remove(op);
		mf.add(np);
		np.setLayout(null);
		np.setSize(1400,900);
		mf.repaint();
	
	}
}


		

