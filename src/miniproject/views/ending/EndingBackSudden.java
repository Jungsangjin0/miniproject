package miniproject.views.ending;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EndingBackSudden extends JPanel { //돌발게임

	ImageIcon imageicon = new ImageIcon("images/ending_sudden.PNG");

	Image image = imageicon.getImage();

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
	

	}

	
}
