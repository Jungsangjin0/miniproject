package miniproject.views.somang;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import miniProject4.com.kh.views.Park.clickPanel;

public class Park2 extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private ImageIcon icon;
	private ImageIcon talk;
	private ImageIcon Mark;

	public Park2() {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		// 諛곌꼍
		icon = new ImageIcon("image/park/park2.png");
		// ���솕李�
		talk = new ImageIcon("image/park/talkFrame.png");
		// �뒓�굦�몴
		

		//this.addMouseListener(new clickPanel());

	}

	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);		
		g.setFont(new Font("Neo�뫁洹쇰え", Font.BOLD, 40));
		g.drawString("�닔�긽�븳 �궗�엺 : �옄�꽕 �듃濡쒗듃�쓽 �떊�씠 �릺�뼱 蹂댁� �븡�쓣 �뀗媛�?", 70, 730);
		g.drawString("愿��떖�씠 �엳�떎硫� �궡媛� �엳�뒗 JYB�냼�냽�궗濡� �삤寃뚮굹!", 290, 780);
		
		setOpaque(false); // 洹몃┝�쓣 �몴�떆�븯寃� �꽕�젙,�닾紐낇븯寃� 議곗젅
		super.paintComponent(g);
	}

	/*class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.replacePanel(mf, panel, new Park2());
		}

	}*/
	
}