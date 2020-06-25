package practice.suddenGame;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GamePanelReal extends JPanel {
	private Banner banner = new Banner();
	private Gamepan pan = new Gamepan();
	private GamePanelReal panel = this;
	
	public void paintComponent(Graphics g) {
		ImageIcon bground = new ImageIcon("suddenGame/bground_0.jpg");
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); 
		super.paintComponent(g);
	}
	
	public GamePanelReal () {
		pan.setLocation(30,30);
		this.add(pan);
		

		
	}
}
