package miniproject.views.ending;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.MainFrame;

public class EndingBack03 extends JPanel { //76~100% ���۽�Ÿ(ĳ����X)

	private EndingBack03 panel = this;
	private MainFrame mf;
	private Player123 player;
	
	private ImageIcon imageicon = new ImageIcon("src/miniproject/images/SJH/endingstar.gif");

	private Image image = imageicon.getImage();
	
	public EndingBack03(MainFrame mf, Player123 player) {
		this.mf = mf;
		this.player = player;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Neo�ձٸ�",Font.BOLD,30));
		g.drawString("������~", 50, 50);

	}

}

