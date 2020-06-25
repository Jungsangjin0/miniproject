package miniProject4.com.kh.views;

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
		// 배경
		icon = new ImageIcon("image/park/park2.png");
		// 대화창
		talk = new ImageIcon("image/park/talkFrame.png");
		// 느낌표
		

		//this.addMouseListener(new clickPanel());

	}

	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);		
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("수상한 사람 : 자네 트로트의 신이 되어 보지 않을 텐가?", 70, 730);
		g.drawString("관심이 있다면 내가 있는 JYB소속사로 오게나!", 290, 780);
		
		setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}

	/*class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.replacePanel(mf, panel, new Park2());
		}

	}*/
	
}