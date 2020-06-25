package miniProject4.com.kh.views;

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
	
	public static void replacePanel(JFrame mf, JPanel panel, JPanel panel2) {
		mf.remove(panel);
		mf.add(panel2);
		mf.repaint(); //메인프레임을 갱신
		mf.revalidate(); // 상위 타입 JFrame위의 container를 갱신 
	}
	
	
//	public void replacePanel(JPanel changePanel) {
//		mf.remove(panel);
//		mf.add(changePanel);
//		mf.repaint();
//	}
//	
//	public void resetPanel() {
//		mf.remove(panel);
//		mf.add(panel);
//		mf.repaint();
//	}
//	
//	public void replaceRankPanel(JPanel changePanel){
//		mf.remove(panel);
//		mf.add(changePanel);
//		mf.repaint();
//	}

	
	
}
