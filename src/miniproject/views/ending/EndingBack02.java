package miniproject.views.ending;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EndingBack02 extends JPanel { //51~75% ����Ÿ(��ĳ����)


	ImageIcon imageicon = new ImageIcon("images/ending_02.PNG");

	Image image = imageicon.getImage();

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Neo�ձٸ�",Font.BOLD,30));
		g.drawString("������~", 50, 50);

	}
}


