package miniproject.views.ending;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.MainFrame;

public class EndingBack01 extends JPanel { //0~50% - �汸����Ÿ(��ĳ����)
	
	ImageIcon imageicon = new ImageIcon("src/miniproject/images/SJH/ending_01.PNG");
	Image image = imageicon.getImage();
	MainFrame mf;
	EndingBack01 panel = this;
	Player123 player;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Neo�ձٸ�",Font.BOLD,30));
		g.drawString("������~", 50, 50);
		
	}
	
	public EndingBack01(MainFrame mf, Player123 player) {
		this.mf = mf;
		this.player = player;
		this.setFocusable(true);
				
	}
	
}
	

		

