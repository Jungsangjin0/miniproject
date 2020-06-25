package com.kh.practice.jungukGame.views;

import javax.swing.*;

public class Timer extends Thread{
	private JFrame mf;
	private JPanel panel;
	private String userId;
	
	public Timer(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}
	
	@Override
	public void run() {
		JTextField label = new JTextField("�����ð� : ");
		label.setBounds(1200, 0 , 100, 50);
		panel.add(label);
		for(int i = 60; i >= 0; i--) {
			try {
				System.out.println(i);
				this.sleep(100);
				label.setText("���� �ð� : " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		userId = JOptionPane.showInputDialog("���̵� �Է��ϼ���!");
		saveScore(userId);
	}
	
	public void saveScore(String userId) {
//		new ScoreManager(userId, mf, panel).saveScore();
	}
	
}
