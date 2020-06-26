package miniproject.views.ending;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.views.MainFrame;

public class EndingBack03 extends JPanel { //76~100% ½´ÆÛ½ºÅ¸(Ä³¸¯ÅÍX)

	private EndingBack03 panel = this;
	private MainFrame mf;
	
	ImageIcon imageicon = new ImageIcon("images/ending_03.PNG");

	Image image = imageicon.getImage();
	
	public EndingBack03(MainFrame mf) {
		this.mf = mf;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("NeoµÕ±Ù¸ð",Font.BOLD,30));
		g.drawString("ÃÑÁ¡Àº~", 50, 50);

	}

}

