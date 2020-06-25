package com.kh.event.Practice.ChangePanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubPage extends JPanel {
	
	public SubPage() {
		this.setSize(1400, 900);
		Image icon = new ImageIcon("images/Junguk.PNG").getImage().getScaledInstance(1400, 900, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		this.add(label, "Center");
	}
	
	public static void main(String[] args) {
		JFrame mf = new JFrame();
		mf.add(new SubPage());
		mf.setSize(1400, 900);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
