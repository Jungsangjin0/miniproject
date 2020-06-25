package miniproject.views.ending;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EndingBack02 extends JPanel { //51~75% 무명스타(남캐릭터)


	ImageIcon imageicon = new ImageIcon("images/ending_02.PNG");

	Image image = imageicon.getImage();

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Neo둥근모",Font.BOLD,30));
		g.drawString("총점은~", 50, 50);

	}
}


