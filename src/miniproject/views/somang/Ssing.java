package miniproject.views.somang;

import java.awt.Font;
import java.awt.Graphics;
//import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import miniproject.views.MainFrame;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;

public class Ssing extends JPanel {
	private MainFrame mf;
	private JPanel panel;
	private ImageIcon icon;
	private ImageIcon talk;
	private ImageIcon charac01;

	public Ssing(MainFrame mf) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		icon = new ImageIcon("src/miniproject/images/ssing/sosokSing.png");
		talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png");
		charac01 = new ImageIcon("src/miniproject/images/ssing/Characters01.gif");

		this.addMouseListener(new clickPanel());

		/*
		 * panel.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { ChangePanel cp = new
		 * ChangePanel(mf,panel); Ssing2 s2 = new Ssing2(mf); cp.replacePanel(s2); } });
		 */
	
	}

	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 50, 200, 398, 398, this);
		}

		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("오늘도 노래 연습을 해보자!", 70, 750);

		setOpaque(false);
		super.paintComponent(g);
	}

//	public void stop(int cnt) {
//		Timer timer = new Timer(mf,panel);
//		Thread t1 = timer;
//		t1.start();
//		if(cnt >= 2) {
//			try {
//				t1.stop();
//				
//			}catch() {
//				
//			}
//		}
//	}
	
	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			//ChangePanel.replacePanel(mf, panel, new Ssing2());
			//ChangePanel cp = new ChangePanel(mf,panel, panel);
			Ssing2 gp = new Ssing2(mf);
			Timer2 timer = new Timer2(mf,gp);
			Thread t1 = timer;
			t1.start();
	
			
			
			
			ChangePanel.changePanel(mf, panel, gp);
			
		}

	}

}
