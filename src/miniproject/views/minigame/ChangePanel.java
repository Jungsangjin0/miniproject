package miniproject.views.minigame;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ChangePanel {
	private JFrame mf;
	private JPanel panel;
	private JPanel panel2;
	
	
	
	public ChangePanel(JFrame mf, JPanel panel, JPanel panel2) {
		this.mf = mf;
		this.panel = panel;
		//this.panel2 = panel2;
	}
	
	public void resetPanel(){
		System.out.println("패널변경");
		mf.remove(panel);
		//JPanel panel = new GamePanel(mf);
		mf.add(panel2);
		mf.repaint();
	}
	
/*	public void replacePanel(){
		System.out.println("패널변경2");
		mf.remove(panel);

		mf.add(panel);
		mf.repaint();
	}
	*/
	
	public static void changePanel(JFrame mf, JPanel panel, JPanel panel2) {
		mf.remove(panel);
		mf.add(panel2);
		mf.repaint(); 
		mf.revalidate(); 
	}
}
