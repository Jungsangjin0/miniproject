package com.kh.practice.jungukGame.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class GamePanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private JLabel junguk;
	private JTextField scoreLabel;
	private JLabel[] arrows;
	private ArrayList<JLabel> inputs;
	private int[] arrNo;
	private int x = 50;
	private int x2 = 50;
	private int index = 0;
	private int ctn = 0;
	private static int point = 0;
	private String uwerId;



	public GamePanel(JFrame mf) {
		this.mf = mf;
		panel = this;

		arrows = new JLabel[5];
		inputs = new ArrayList<JLabel>();
		arrNo = new int[5];

		this.setBounds(0, 0, 1400, 900);
		scoreLabel();
		System.out.println("패널생성");
	}


	public void inputword() {
		Scanner sc = new Scanner(System.in);



	}	

	public void scoreLabel(){
		scoreLabel = new JTextField("SCORE : " + point);
		scoreLabel.setFont(new Font("Sanscerif", Font.BOLD, 20));
		scoreLabel.setBorder(BorderFactory.createEmptyBorder());
		scoreLabel.setBackground(Color.blue);
		this.setComponentZOrder(scoreLabel, 0);
		scoreLabel.setBounds(20, 0, 200, 50);
		this.add(scoreLabel);
	}

}

