package miniproject.views.suddenGame;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

import miniproject.views.MainFrame;

public class GamePanelReal extends JPanel {
	private Banner banner = new Banner();
	private Gamepan pan = new Gamepan();
	private GamePanelReal panel = this;
	private MainFrame mf;
	
	public void paintComponent(Graphics g) {
		ImageIcon bground = new ImageIcon("src/miniproject/images/suddenGame/bground_0.jpg");
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); 
		super.paintComponent(g);
	}
	
	public GamePanelReal (MainFrame mf) {
		this.mf = mf;
		pan.setLocation(30,30);
		this.add(pan);
		

		
	}
}
