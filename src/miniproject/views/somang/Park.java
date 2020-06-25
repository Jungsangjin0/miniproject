package miniproject.views.somang;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import miniProject4.com.kh.views.Ssing.clickPanel;

public class Park extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private ImageIcon icon;
	private ImageIcon talk;
	private ImageIcon Mark;
	private ImageIcon charac01;

	public Park(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		//諛곌꼍
		icon = new ImageIcon("image/park/park.png");
		//���솕李�
		talk = new ImageIcon("image/park/talkFrame.png");
		//�뒓�굦�몴
		Mark = new ImageIcon("image/park/exMark.png");
		
		this.addMouseListener(new clickPanel());

	
	}
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 50, 200, 398, 398, this);
		}
		g.setFont(new Font("Neo�뫁洹쇰え", Font.BOLD, 40));
		g.drawString("!!! �닔�긽�븳 �궗�엺�씠�떎 !!!", 70, 750);
		g.drawImage(Mark.getImage(),900, 250, 154, 174, null);
		setOpaque(false); // 洹몃┝�쓣 �몴�떆�븯寃� �꽕�젙,�닾紐낇븯寃� 議곗젅
		super.paintComponent(g);
	}
	
	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.replacePanel(mf, panel, new Park2());
		}

	}

	
}
