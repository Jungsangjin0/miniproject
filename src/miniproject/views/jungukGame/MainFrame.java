package com.kh.practice.junguk;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame{

	public MainFrame() {
		this.setSize(1400, 900);
		
		MainPage mp = new MainPage(this);
		mp.setLayout(null);
		this.add(mp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}






