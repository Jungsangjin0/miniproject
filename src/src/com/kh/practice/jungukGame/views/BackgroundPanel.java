package com.kh.practice.jungukGame.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class BackgroundPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	public BackgroundPanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/Junguk_2.PNG").getImage().getScaledInstance(1400, 900, 0)));
		label.setBounds(0, 0, 1400, 900);
		
		JLabel malpung = new JLabel(new ImageIcon(new ImageIcon("images/mal_junguk1.PNG").getImage().getScaledInstance(1400, 250, 0)));
		malpung.setBounds(0, 650, 1400, 250);
		
		malpung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				GamePanel gp = new GamePanel(mf);
				Timer timer = new Timer(mf, gp);
				Thread t1 = timer;
				t1.start();
				
				cp.replacePanel(gp);
			}
		});
		
		this.add(label);
		this.add(malpung);
		this.setComponentZOrder(label, 1);
	}
	

}
