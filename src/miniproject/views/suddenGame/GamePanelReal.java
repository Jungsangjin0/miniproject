package miniproject.views.suddenGame;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import practice.suddenGame.ChangePanel;

public class GamePanelReal extends JPanel {
	private Banner banner = new Banner();
	private Gamepan pan = new Gamepan();
	private GamePanelReal panel = this;
	private JButton tempPass = new JButton("Submit");
	
	public void paintComponent(Graphics g) {
		ImageIcon bground = new ImageIcon("suddenGame/bground_0.jpg");
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); 
		super.paintComponent(g);
	}
	
	public GamePanelReal (MainFrame mf) {
		pan.setLocation(30,30);
		this.add(pan);
		
tempPass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, panel, /*새로운 메인맵*/);
			}
			
		});
			tempPass.setLayout(null);
			tempPass.setBounds(1000,50,100,20);
			this.add(tempPass);
		
	}
}
