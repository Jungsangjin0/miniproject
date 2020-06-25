package miniProject4.com.kh.views;

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
		//배경
		icon = new ImageIcon("image/park/park.png");
		//대화창
		talk = new ImageIcon("image/park/talkFrame.png");
		//느낌표
		Mark = new ImageIcon("image/park/exMark.png");
		
		this.addMouseListener(new clickPanel());

	
	}
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 50, 200, 398, 398, this);
		}
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("!!! 수상한 사람이다 !!!", 70, 750);
		g.drawImage(Mark.getImage(),900, 250, 154, 174, null);
		setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	
	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.replacePanel(mf, panel, new Park2());
		}

	}

	
}
