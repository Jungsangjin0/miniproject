package com.kh.practice.junguk;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ChangePanel {
	private JFrame mf;
	private JPanel panel;

	public static void changePanel(MainFrame mf, JPanel op, JPanel np){
		mf.remove(op);
		mf.add(np);
		mf.repaint();
	}
}


		

