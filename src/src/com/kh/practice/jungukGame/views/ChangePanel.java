package com.kh.practice.jungukGame.views;

import javax.swing.*;

public class ChangePanel {
	private JFrame mf;
	private JPanel panel;
	
	
	public ChangePanel(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}
	
	public void replacePanel(JPanel changePanel) {
		mf.remove(panel);
		mf.add(changePanel);
		mf.repaint();
	}
	
	public void resetPanel() {
		System.out.println("패널 변경");
		mf.remove(panel);
		mf.add(panel);
		mf.repaint();
	}
	
	public void replaceRankPanel(JPanel changePanel) {
		mf.remove(panel);
		mf.add(changePanel);
		mf.repaint();
	}
	
	
}
